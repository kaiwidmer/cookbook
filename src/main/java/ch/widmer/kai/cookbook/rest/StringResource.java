package ch.widmer.kai.cookbook.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/string")
public class StringResource {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getString() {
        return "welcome to the string-Service";
    }
    
}
