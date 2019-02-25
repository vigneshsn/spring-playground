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

    Logger LOG = LoggerFactory.getLogger(AuthenticationFilter.class);

    public AuthenticationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        this.authenticationManager = authenticationManager;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    private AuthenticationManager authenticationManager;
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOG.info("filter invoked!!!");
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            String token = request.getHeader("auth-token");
            PreAuthenticatedAuthenticationToken preAuthToken = new PreAuthenticatedAuthenticationToken(token, null);
            Authentication responseAuthentication = authenticationManager.authenticate(preAuthToken);
            SecurityContextHolder.getContext().setAuthentication(responseAuthentication);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            authenticationEntryPoint.commence((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse,
                    new InvalidTokenException("failed" , e) );
        }

    }
}
