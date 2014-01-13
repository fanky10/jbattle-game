package com.doinfinite.battlegame.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.name();
	}
}
