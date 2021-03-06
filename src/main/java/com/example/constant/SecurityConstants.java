package com.example.constant;

public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Token ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/*";
    
    
    public static final String ADMIN_ROLE = "admin";
    public static final String USER_ROLE = "user";
    		
}
