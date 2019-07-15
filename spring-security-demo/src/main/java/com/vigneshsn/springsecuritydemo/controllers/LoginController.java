package com.vigneshsn.springsecuritydemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
    Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/login")
    @PostMapping
    public void login() {
        log.info("login successfull");
    }
}
