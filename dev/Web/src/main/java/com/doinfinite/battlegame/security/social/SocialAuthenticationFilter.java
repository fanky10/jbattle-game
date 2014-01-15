package com.doinfinite.battlegame.security.social;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ProviderSignInAttempt;
import org.springframework.util.Assert;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class SocialAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	private String signupUrl = "/signup";
	private static final String DEFAULT_FAILURE_URL = "/signin";
	private String connectionAddedRedirectUrl = "/";
	private boolean updateConnections = true;
	private UsersConnectionRepository usersConnectionRepository;
	private SimpleUrlAuthenticationFailureHandler delegateAuthenticationFailureHandler;
	private ConnectionFactoryLocator connectionFactoryLocator;
	private ConnectionFactoryRegistry registry;

	protected SocialAuthenticationFilter(AuthenticationManager authManager,
			UsersConnectionRepository usersConnectionRepository, ConnectionFactoryRegistry connectionFactoryRegistry) {
		super("/social");
		setAuthenticationManager(authManager);// SocialAuthenticationManager
												// ref.
		this.usersConnectionRepository = usersConnectionRepository;
		this.delegateAuthenticationFailureHandler = new SimpleUrlAuthenticationFailureHandler(DEFAULT_FAILURE_URL);
		super.setAuthenticationFailureHandler(new SocialAuthenticationFailureHandler(
				delegateAuthenticationFailureHandler));
		this.connectionFactoryLocator = connectionFactoryRegistry;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		if (detectRejection(request)) {
			if (logger.isDebugEnabled()) {
				logger.debug("A rejection was detected. Failing authentication.");
			}
			throw new SocialAuthenticationException("Authentication failed because user rejected authorization.");
		}

		Authentication auth = null;
		Set<String> authProviders = connectionFactoryLocator.registeredProviderIds();
		String authProviderId = getRequestedProviderId(request);
		if (!authProviders.isEmpty() && authProviderId != null && authProviders.contains(authProviderId)) {
			ConnectionFactory<?> connectionFactory = registry.getConnectionFactory(authProviderId);
			auth = attemptAuthService(connectionFactory, request, response);
			if (auth == null) {
				throw new AuthenticationServiceException("authentication failed");
			}
		}
		return auth;
	}

	/*
	 * Call SocialAuthenticationService.getAuthToken() to get
	 * SocialAuthenticationToken: If first phase, throw
	 * AuthenticationRedirectException to redirect to provider website. If
	 * second phase, get token/code from request parameter and call provider API
	 * to get accessToken/accessGrant. Check Authentication object in spring
	 * security context, if null or not authenticated, call doAuthentication()
	 * Otherwise, it is already authenticated, add this connection.
	 */
	private Authentication attemptAuthService(final ConnectionFactory<?> connectionFactory,
			final HttpServletRequest request, HttpServletResponse response)
			throws SocialAuthenticationRedirectException, AuthenticationException {

		final SocialAuthenticationToken token = null;
		if (token == null)
			return null;

		Assert.notNull(token.getConnection());

		Authentication auth = getAuthentication();
		if (auth == null || !auth.isAuthenticated()) {
			return doAuthentication(request, token);
		} else {
			addConnection(request, token, auth);
			return null;
		}
	}

	private Authentication doAuthentication(HttpServletRequest request, SocialAuthenticationToken token) {
		try {
			token.setDetails(authenticationDetailsSource.buildDetails(request));
			Authentication success = getAuthenticationManager().authenticate(token);
			Assert.isInstanceOf(UserDetails.class, success.getPrincipal(), "unexpected principle type");
			updateConnections(token, success);
			return success;
		} catch (BadCredentialsException e) {
			// connection unknown, register new user?
			if (signupUrl != null) {
				// store ConnectionData in session and redirect to register page
				addSignInAttempt(request.getSession(), token.getConnection());
				throw new SocialAuthenticationRedirectException(buildSignupUrl(request));
			}
			throw e;
		}
	}

	private void addConnection(HttpServletRequest request, SocialAuthenticationToken token, Authentication auth) {
		// already authenticated - add connection instead
		String userId = getUserId();
		Object principal = token.getPrincipal();

		if (userId == null || !(principal instanceof ConnectionData))
			return;

		Connection<?> connection = addConnection(userId, (ConnectionData) principal);
		if (connection != null) {
			throw new SocialAuthenticationRedirectException(connectionAddedRedirectUrl);
		}
	}

	protected Connection<?> addConnection(String userId, ConnectionData data) {
		HashSet<String> userIdSet = new HashSet<String>();
		userIdSet.add(data.getProviderUserId());
		Set<String> connectedUserIds = usersConnectionRepository
				.findUserIdsConnectedTo(data.getProviderId(), userIdSet);
		if (connectedUserIds.contains(userId)) {
			// already connected
			return null;
		} else if (!connectedUserIds.isEmpty()) {
			return null;
		}

		ConnectionRepository repo = usersConnectionRepository.createConnectionRepository(userId);

		List<Connection<?>> connections = repo.findConnections(data.getProviderId());
		if (!connections.isEmpty()) {
			// TODO maybe throw an exception to allow UI feedback?
			return null;
		}

		// add new connection
		Connection<?> connection = connectionFactoryLocator.getConnectionFactory(data.getProviderId())
				.createConnection(data);
		connection.sync();
		repo.addConnection(connection);
		return connection;
	}

	private void updateConnections(SocialAuthenticationToken token, Authentication success) {
		if (updateConnections) {
			String userId = ((UserDetails) success.getPrincipal()).getUsername();
			Connection<?> connection = token.getConnection();
			ConnectionRepository repo = getUsersConnectionRepository().createConnectionRepository(userId);
			repo.updateConnection(connection);
		}
	}

	// private helpers
	private Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	private String buildSignupUrl(HttpServletRequest request) {
		if (signupUrl.startsWith("http://") || signupUrl.startsWith("https://")) {
			return signupUrl;
		}
		if (!signupUrl.startsWith("/")) {
			return ServletUriComponentsBuilder.fromContextPath(request).path("/" + signupUrl).build().toUriString();
		}
		return ServletUriComponentsBuilder.fromContextPath(request).path(signupUrl).build().toUriString();
	}

	private void addSignInAttempt(HttpSession session, Connection<?> connection) {
		session.setAttribute(ProviderSignInAttempt.class.getName(), new ProviderSignInAttempt(connection,
				connectionFactoryLocator, usersConnectionRepository));
	}

	private String getRequestedProviderId(HttpServletRequest request) {
		String uri = request.getRequestURI();
		int pathParamIndex = uri.indexOf(';');

		if (pathParamIndex > 0) {
			// strip everything after the first semi-colon
			uri = uri.substring(0, pathParamIndex);
		}

		// uri must start with context path
		uri = uri.substring(request.getContextPath().length());

		// remaining uri must start with filterProcessesUrl
		if (!uri.startsWith(getFilterProcessesUrl())) {
			return null;
		}
		uri = uri.substring(getFilterProcessesUrl().length());

		// expect /filterprocessesurl/provider, not /filterprocessesurlproviderr
		if (uri.startsWith("/")) {
			return uri.substring(1);
		} else {
			return null;
		}
	}

	/**
	 * Detects a callback request after a user rejects authorization to prevent
	 * a never-ending redirect loop. Default implementation detects a rejection
	 * as a request that has one or more parameters, but none of the expected
	 * parameters (oauth_token, code, scope). May be overridden to customize
	 * rejection detection.
	 * 
	 * @param request
	 *            the request to check for rejection.
	 * @return true if the request appears to be the result of a rejected
	 *         authorization; false otherwise.
	 */
	protected boolean detectRejection(HttpServletRequest request) {
		Set<?> parameterKeys = request.getParameterMap().keySet();
		return parameterKeys.size() > 0 && !parameterKeys.contains("oauth_token") && !parameterKeys.contains("code")
				&& !parameterKeys.contains("scope");
	}

	private String getUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
		}
		return authentication.getName();
	}

	public String getSignupUrl() {
		return signupUrl;
	}

	public void setSignupUrl(String signupUrl) {
		this.signupUrl = signupUrl;
	}

	public String getConnectionAddedRedirectUrl() {
		return connectionAddedRedirectUrl;
	}

	public void setConnectionAddedRedirectUrl(String connectionAddedRedirectUrl) {
		this.connectionAddedRedirectUrl = connectionAddedRedirectUrl;
	}

	public boolean isUpdateConnections() {
		return updateConnections;
	}

	public void setUpdateConnections(boolean updateConnections) {
		this.updateConnections = updateConnections;
	}

	public UsersConnectionRepository getUsersConnectionRepository() {
		return usersConnectionRepository;
	}

	public void setUsersConnectionRepository(UsersConnectionRepository usersConnectionRepository) {
		this.usersConnectionRepository = usersConnectionRepository;
	}

	public SimpleUrlAuthenticationFailureHandler getDelegateAuthenticationFailureHandler() {
		return delegateAuthenticationFailureHandler;
	}

	public void setDelegateAuthenticationFailureHandler(
			SimpleUrlAuthenticationFailureHandler delegateAuthenticationFailureHandler) {
		this.delegateAuthenticationFailureHandler = delegateAuthenticationFailureHandler;
	}

}
