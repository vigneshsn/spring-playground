package com.vigneshsn.springsecuritydemo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter extends GenericFilterBean {

    Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);

    public AuthenticationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint unAuthenticationEntryPoint) {
        this.authenticationManager = authenticationManager;
        this.authenticationEntryPoint = unAuthenticationEntryPoint;
    }

    private AuthenticationManager authenticationManager;
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("filter invoked!!!");
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            String token = request.getHeader("auth-token");
            String tokenSetByLoginFilter = (String) request.getAttribute("auth-token");
            String authToken = tokenSetByLoginFilter == null ? token: tokenSetByLoginFilter;
            log.info("token {} , {}", token, tokenSetByLoginFilter );
            PreAuthenticatedAuthenticationToken preAuthToken = new PreAuthenticatedAuthenticationToken(authToken, null);
            Authentication responseAuthentication = authenticationManager.authenticate(preAuthToken);
            SecurityContextHolder.getContext().setAuthentication(responseAuthentication);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            authenticationEntryPoint.commence((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse,
                    new InvalidTokenException("failed" , e) );
        }

    }
}
