package com.doinfinite.battlegame.security.social;

import org.springframework.security.core.AuthenticationException;

/**
 * Indicates an error while authenticating against a social provider.
 * @author Stefan Fusseneger
 */
@SuppressWarnings("serial")
public class SocialAuthenticationException extends AuthenticationException {

	public SocialAuthenticationException(String message) {
		super(message);
	}

	public SocialAuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}

}
