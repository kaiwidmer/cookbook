package ch.widmer.kai.cookbook.rest;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
    
    private static final String AUTHENTICATION = "Bearer";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {        
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader == null || !authorizationHeader.startsWith(AUTHENTICATION)) {
            requestContext.abortWith(Response.status(Status.UNAUTHORIZED).build());
            return;
        }
        
        String token = authorizationHeader.substring(AUTHENTICATION.length()).trim();
        
    }
}
