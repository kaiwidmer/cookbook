package ch.widmer.kai.cookbook.rest.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Authenticator {
    
    public Optional<String> authenticate(String username, String password) {
        List<String> groups = new ArrayList<>();
        groups.add("test");
        try {
            String jwt = Jwts.builder()
              .setSubject("users/TzMUocMF4p")
              .setExpiration(new Date(2017, 12, 12))
              .claim(JWTConstants.CLAIM_USERNAME, username)
              .claim(JWTConstants.CLAIM_GROUPS, groups)
              .signWith(SignatureAlgorithm.HS256, JWTConstants.SIGNINGKEY.getBytes(JWTConstants.SIGNINGKEY_ENCODING))
              .compact();
            return Optional.of(jwt);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
