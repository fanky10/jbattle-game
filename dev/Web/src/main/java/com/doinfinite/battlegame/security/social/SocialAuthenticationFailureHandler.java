package com.doinfinite.battlegame.security.social;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * @author Craig Walls
 */
public class SocialAuthenticationFailureHandler implements
		AuthenticationFailureHandler {

	private AuthenticationFailureHandler delegate;

	public SocialAuthenticationFailureHandler(
			AuthenticationFailureHandler delegate) {
		this.delegate = delegate;
	}

	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException failed)
			throws IOException, ServletException {
		if (failed instanceof SocialAuthenticationRedirectException) {
			response.sendRedirect(((SocialAuthenticationRedirectException) failed)
					.getRedirectUrl());
			return;
		}
		delegate.onAuthenticationFailure(request, response, failed);
	}

}
