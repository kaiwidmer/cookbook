package ch.widmer.kai.cookbook.rest;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ch.widmer.kai.cookbook.boundary.dto.UserDTO;
import ch.widmer.kai.cookbook.rest.security.Authenticator;

@Path("/authentication")
public class AuthenticationResource {
    
    @Inject
    private Authenticator authenticator;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        Optional<String> token = authenticator.authenticate(username, password);
        if(token.isPresent()) {
            return Response.ok(token.get()).build();
        }
        return Response.status(Status.FORBIDDEN).build();
    }
    
}
