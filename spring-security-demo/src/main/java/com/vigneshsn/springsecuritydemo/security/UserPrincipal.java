package com.vigneshsn.springsecuritydemo.security;

public class UserPrincipal {
    private String name;
    private String id;

    public UserPrincipal(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
;