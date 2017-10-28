package ch.widmer.kai.cookbook.rest.security;

import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

import java.io.IOException;
import java.util.List;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import static ch.widmer.kai.cookbook.rest.security.JWTConstants.*;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    public static final String AUTHENTICATION = "Bearer";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader == null || !authorizationHeader.startsWith(AUTHENTICATION)) {
            requestContext.abortWith(Response.status(Status.UNAUTHORIZED).build());
            return;
        }

        String token = authorizationHeader.substring(AUTHENTICATION.length()).trim();
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(SIGNINGKEY.getBytes(SIGNINGKEY_ENCODING)).parseClaimsJws(token);
            String username = claims.getBody().get(CLAIM_USERNAME).toString();
            List<String> groups = (List<String>)claims.getBody().get(CLAIM_GROUPS);
            requestContext.setSecurityContext(new CookbookSecurityContext(username, groups));
            
        } catch (ClaimJwtException | MalformedJwtException | SignatureException e) {
            requestContext.abortWith(Response.status(Status.UNAUTHORIZED).build());
        }
    }
}
