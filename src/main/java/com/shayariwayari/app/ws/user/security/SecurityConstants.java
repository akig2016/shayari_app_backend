package com.shayariwayari.app.ws.user.security;

import com.shayariwayari.app.ws.SpringApplicationContext;

public class SecurityConstants {
    public static final long EXPIRATION_TIME = 864000000; //10Days in miliseconds
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String SIGNUP_URL = "/user";
    public static final String HEADER_STRING = "Authorization";
    public static String getTokenSecret()
    {
        AppPropertyReader appPropertyReader = (AppPropertyReader) SpringApplicationContext.getBean("AppPropertyReader");
        return appPropertyReader.getTokenSecret();
    }
}
