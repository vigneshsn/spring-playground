package com.vigneshsn.springsecuritydemo.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class CustomAuthProvider implements AuthenticationProvider {

    public CustomAuthProvider(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    private AuthenticationService authenticationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = authentication.getPrincipal().toString();
        return authenticationService.authenticate(token);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass == PreAuthenticatedAuthenticationToken.class;
    }
}
