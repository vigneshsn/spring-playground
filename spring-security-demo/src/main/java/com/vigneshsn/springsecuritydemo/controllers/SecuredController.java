package com.vigneshsn.springsecuritydemo.controllers;

import com.vigneshsn.springsecuritydemo.security.UserAuthToken;
import com.vigneshsn.springsecuritydemo.security.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/secured")
public class SecuredController {

	Logger log = LoggerFactory.getLogger(getClass());

	@GetMapping("/greetings")
	public String secured(HttpServletRequest request) {
		log.info("secure endpoint invoked!!!");
		UserAuthToken userAuthToken = (UserAuthToken) request.getUserPrincipal();
		UserPrincipal user = (UserPrincipal) userAuthToken.getPrincipal();
		return "welcome "+ user.getName();
	}
}
