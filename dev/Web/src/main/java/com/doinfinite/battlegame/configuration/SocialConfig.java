package com.doinfinite.battlegame.configuration;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

import com.doinfinite.battlegame.security.SimpleSignInAdapter;
import com.doinfinite.battlegame.services.ServicesManager;

@Configuration
public class SocialConfig {

	@Inject
	private DataSource dataSource;
	// TODO: inject proper bean
	private TextEncryptor textEncryptor = Encryptors.noOpText();
	@Value("${facebook.clientId}")
	private String facebookClientId;
	@Value("${facebook.clientSecret}")
	private String facebookClientSecret;
	@Value("${twitter.consumer.key}")
	private String twitterConsumerKey;
	@Value("${twitter.consumer.secret}")
	private String twitterConsumerSecret;
	@Value("${application.homeUrl}")
	private String appUrl;
	
	@Autowired
	private ServicesManager servicesManager;

	@Bean
	public ConnectionFactoryLocator connectionFactoryLocator() {
		ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
		registry.addConnectionFactory(new FacebookConnectionFactory(facebookClientId, facebookClientSecret));
		registry.addConnectionFactory(new TwitterConnectionFactory(twitterConsumerKey, twitterConsumerSecret));

		return registry;
	}

	@Bean
	public UsersConnectionRepository usersConnectionRepository() {
		return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator(), textEncryptor);
	}

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public ConnectionRepository connectionRepository() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
		}
		return usersConnectionRepository().createConnectionRepository(authentication.getName());
	}

	@Bean
	public ProviderSignInController providerSignInController(ConnectionFactoryLocator connectionFactoryLocator,
			UsersConnectionRepository usersConnectionRepository, RequestCache requestCache) {
		ProviderSignInController providerSignInController = new ProviderSignInController(connectionFactoryLocator, usersConnectionRepository,
				new SimpleSignInAdapter(requestCache,servicesManager));
		providerSignInController.setApplicationUrl(appUrl);
		return providerSignInController;
	}

}
