package com.doinfinite.battlegame.configuration;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.support.OAuth1ConnectionFactory;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth1.OAuth1Operations;
import org.springframework.social.oauth1.OAuthToken;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/config/dispatcher-servlet.xml",
		"classpath:/dataAccessContext.xml" })
@Transactional
public class ConnectionFactoryTest extends TestCase {
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

	private ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();

	@Before
	public void buildData() {
		registry.addConnectionFactory(new FacebookConnectionFactory(facebookClientId, facebookClientSecret));
		registry.addConnectionFactory(new TwitterConnectionFactory(twitterConsumerKey, twitterConsumerSecret));
	}

	@Test
	public void testFacebookConnection() {
		ConnectionFactory<?> connectionFactory = registry.getConnectionFactory("facebook");
		assertTrue(connectionFactory != null);
		testConnection(connectionFactory);
	}

	@Test
	public void testTwitterConnection() {
		ConnectionFactory<?> connectionFactory = registry.getConnectionFactory("twitter");
		assertTrue(connectionFactory != null);
		testConnection(connectionFactory);
	}
	
	private void testConnection(ConnectionFactory<?> connectionFactory){
		OAuth1Operations oAuth1Operations = null;
		OAuth2Operations oAuth2Operations = null;
		if (connectionFactory instanceof OAuth1ConnectionFactory) {
			oAuth1Operations = ((OAuth1ConnectionFactory<?>) connectionFactory).getOAuthOperations(); 
			assertTrue(oAuth1Operations!=null);
			MultiValueMap<String, String> additionalParameters = new LinkedMultiValueMap<String, String>();
			assertTrue(oAuth1Operations.fetchRequestToken(appUrl, additionalParameters)!=null);
		} else if (connectionFactory instanceof OAuth2ConnectionFactory) {
			oAuth2Operations = ((OAuth2ConnectionFactory<?>) connectionFactory).getOAuthOperations();
			assertTrue(oAuth2Operations!=null);
		} else {
			throw new IllegalArgumentException("ConnectionFactory not supported");
		}
	}
}
