package com.doinfinite.battlegame.configuration;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

import com.doinfinite.battlegame.model.User;

@Configuration
@EnableSocial
public class SocialConfig implements SocialConfigurer {

	@Inject
	private DataSource dataSource;
	// TODO: inject proper bean
	/**
	 * The TextEncryptor object encrypts the authorization details of the connection. In
	 * our example, the authorization details are stored as plain text.
	 * DO NOT USE THIS IN PRODUCTION.
	 */
	private TextEncryptor textEncryptor = Encryptors.noOpText();
	@Value("${facebook.clientId}")
	private String facebookClientId;
	@Value("${facebook.clientSecret}")
	private String facebookClientSecret;
	@Value("${twitter.consumer.key}")
	private String twitterConsumerKey;
	@Value("${twitter.consumer.secret}")
	private String twitterConsumerSecret;

	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
		connectionFactoryConfigurer.addConnectionFactory(new FacebookConnectionFactory(facebookClientId,
				facebookClientSecret));
		connectionFactoryConfigurer.addConnectionFactory(new TwitterConnectionFactory(twitterConsumerKey,
				twitterConsumerSecret));
	}

	@Override
	public UserIdSource getUserIdSource() {
		// TODO Auto-generated method stub
		return new UserIdSource() {

			@Override
			public String getUserId() {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				if (authentication == null) {
					throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
				}
				User user = (User) authentication.getPrincipal();
				return user.getUserId();
			}
		};
	}

	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, textEncryptor);
	}

	@Bean
	public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator,
			ConnectionRepository connectionRepository) {
		ConnectController controller = new ConnectController(connectionFactoryLocator, connectionRepository);
		// TODO: callback url
		// controller.setApplicationUrl(environment.getProperty("application.url"));
		return controller;
	}

}
