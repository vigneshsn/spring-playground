package com.vigneshsn.springsecuritydemo.security;

public class AuthenticationService {

    public UserAuthToken authenticate(String token) {
        if("expected".equals(token)) {

            UserPrincipal user = new UserPrincipal("vignesh", "1234");
            return new UserAuthToken(user, null, null);
        }

        throw new RuntimeException("Not an expected user");
    }
}
