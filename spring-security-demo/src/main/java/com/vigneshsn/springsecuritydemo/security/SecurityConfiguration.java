package com.vigneshsn.springsecuritydemo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	Logger LOG = LoggerFactory.getLogger(SecurityConfiguration.class);
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		LOG.info("security config invoked!!!");
		httpSecurity
				.csrf().disable()
				.exceptionHandling()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				//.antMatchers(HttpMethod.OPTIONS,"/auth/login").permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.addFilterBefore(new LoginFilter(new AntPathRequestMatcher("/auth/login")), UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new AuthenticationFilter(authenticationManager(), new UnAuthenticatedEntryPoint()),
						UsernamePasswordAuthenticationFilter.class
				);
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(new CustomAuthProvider((new AuthenticationService())));
	}
}
