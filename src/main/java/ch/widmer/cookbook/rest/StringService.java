package ch.widmer.cookbook.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/string")
public class StringService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPhones() {
        return "hello Dennis";
    }
}
