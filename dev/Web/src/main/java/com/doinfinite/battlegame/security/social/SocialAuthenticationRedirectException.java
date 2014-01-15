package com.doinfinite.battlegame.security.social;

import java.net.URL;

import org.springframework.security.core.AuthenticationException;

/**
 * Indicates the need to perform a redirect in the course of authenticating with a social provider. 
 * @author Stefan Fusseneger
 */
@SuppressWarnings("serial")
public class SocialAuthenticationRedirectException extends AuthenticationException {

	private final String redirectUrl;

	public SocialAuthenticationRedirectException(URL redirectUrl) {
	    this(redirectUrl.toString());
	}

	public SocialAuthenticationRedirectException(String redirectUrl) {
	    super("");
		this.redirectUrl = redirectUrl;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

}
