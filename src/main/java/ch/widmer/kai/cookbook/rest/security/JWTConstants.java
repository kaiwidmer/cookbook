package ch.widmer.kai.cookbook.rest.security;

public interface JWTConstants {
    
    static String SIGNINGKEY = "secret";
    static String SIGNINGKEY_ENCODING = "UTF-8";
    static String CLAIM_USERNAME = "username";
    static String CLAIM_GROUPS = "groups";
    
    
}
