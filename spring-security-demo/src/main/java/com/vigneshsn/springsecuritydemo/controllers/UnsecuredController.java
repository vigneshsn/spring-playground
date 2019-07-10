package com.vigneshsn.springsecuritydemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anonymous")
public class UnsecuredController {
	Logger log = LoggerFactory.getLogger(getClass());

	@GetMapping("/guest-greetings")
	public String unsecured() {
		log.info("unsecured endpoint invoked");
		return "Welcome guest";
	}
}
