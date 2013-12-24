package com.doinfinite.battlegame.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		if (username.equals("admin") && password.equals("admin")) {
			return new UsernamePasswordAuthenticationToken(username, password,
					getAuthorities());
		}
		throw new BadCredentialsException("Username or password is not valid.");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

	private List<Role> getAuthorities() {
		Role r = new Role();
		r.setName("ROLE_USER");
		List<Role> authorities = new ArrayList<Role>();
		authorities.add(r);
		return authorities;
	}

}
