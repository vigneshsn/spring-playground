package com.vigneshsn.springsecuritydemo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	Logger LOG = LoggerFactory.getLogger(SecurityConfiguration.class);
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		LOG.info("security config invoked!!!");
		httpSecurity.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				.antMatchers("/secured")
				.authenticated()
				.and()
				.addFilterBefore(
						new AuthenticationFilter(authenticationManager(), new UnAuthenticatedEntryPoint()),
						BasicAuthenticationFilter.class
				);
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(new CustomAuthProvider((new AuthenticationService())));
	}
}
