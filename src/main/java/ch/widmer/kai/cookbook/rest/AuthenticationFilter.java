package ch.widmer.kai.cookbook.rest;

import java.io.IOException;

import javax.annotation.security.DenyAll;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {
    
    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if(resourceInfo.getResourceMethod().isAnnotationPresent(DenyAll.class)) {
            requestContext.abortWith(Response.status(Status.METHOD_NOT_ALLOWED).build());
            
        }
        
    }
}
