package com.doinfinite.battlegame.security.social;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.ServiceProvider;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.util.Assert;

/**
 * Authentication token for social authentication, e.g. Twitter or Facebook
 * 
 * @author Stefan Fussennegger
 * @author Yuan Ji
 */
@SuppressWarnings("serial")
public class SocialAuthenticationToken extends AbstractAuthenticationToken {

	private final String providerId;

	private final Serializable principle;
	
	private final Connection<?> connection;

	private final Map<String, String> providerAccountData;

	/**
	 * @param connection connection data
	 * @param providerAccountData optional extra account data
	 */
	public SocialAuthenticationToken(final Connection<?> connection, Map<String, String> providerAccountData) {
		super(null);
		Assert.notNull(connection);
		ConnectionData connectionData = connection.createData();
		Assert.notNull(connectionData.getProviderId());
		if (connectionData.getExpireTime() != null && connectionData.getExpireTime() < System.currentTimeMillis()) {
			throw new IllegalArgumentException("connection.expireTime < currentTime");
		}
		this.providerId = connectionData.getProviderId();
		this.connection = connection;
		this.principle = null; //no principal yet
		if (providerAccountData != null) {
			this.providerAccountData = Collections.unmodifiableMap(new HashMap<String, String>(providerAccountData));
		} else {
			this.providerAccountData = Collections.emptyMap();
		}
		super.setAuthenticated(false);
	}

	/**
	 * @param connection {@link Connection}
	 * @param details user details, typically as returned by {@link SocialUserDetailsService}
	 * @param providerAccountData optional extra account data
	 * @param authorities any {@link GrantedAuthority}s for this user
	 */
	public SocialAuthenticationToken(final Connection<?> connection, final Serializable details, final Map<String, String> providerAccountData, final Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		Assert.notNull(connection);
        this.connection = connection;
        ConnectionData connectionData = connection.createData();
        Assert.notNull(connectionData.getProviderId());
        this.providerId = connectionData.getProviderId();
        if (details == null) {
			throw new NullPointerException("details");
		}
		this.principle = details;
		if (providerAccountData != null) {
			this.providerAccountData = Collections.unmodifiableMap(new HashMap<String, String>(providerAccountData));
		} else {
			this.providerAccountData = Collections.emptyMap();
		}
		super.setAuthenticated(true);
	}

	/**
	 * @return {@link ServiceProvider} id
	 */
	public String getProviderId() {
		return providerId;
	}

	/**
	 * @return always null
	 */
	public Object getCredentials() {
		return null;
	}

	/**
	 * @return The user's principal. Null if not authenticated.
	 */
	public Serializable getPrincipal() {
		return principle;
	}

    public Connection<?> getConnection(){
        return connection;
    }

    /**
	 * @return unmodifiable map, never null
	 */
	public Map<String, String> getProviderAccountData() {
		return providerAccountData;
	}

	/**
	 * @throws IllegalArgumentException when trying to authenticate a previously unauthenticated token
	 */
	@Override
	public void setAuthenticated(final boolean isAuthenticated) throws IllegalArgumentException {
		if (!isAuthenticated) {
			super.setAuthenticated(false);
		} else if (!super.isAuthenticated()) {
			throw new IllegalArgumentException(
					"Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
		}
	}

}