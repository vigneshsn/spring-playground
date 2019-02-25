package com.vigneshsn.springsecuritydemo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.Collection;

public class UserAuthToken extends PreAuthenticatedAuthenticationToken {

    public UserAuthToken(UserPrincipal aPrincipal, Object aCredentials, Collection<? extends GrantedAuthority> anAuthorities) {
        super(aPrincipal, aCredentials, anAuthorities);
    }
}
