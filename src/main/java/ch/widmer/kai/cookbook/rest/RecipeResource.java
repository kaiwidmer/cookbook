package ch.widmer.kai.cookbook.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.widmer.kai.cookbook.domain.Recipe;
import ch.widmer.kai.cookbook.repository.RecipeRepository;
import ch.widmer.kai.cookbook.rest.security.Secured;

@Secured
@Path("/recipes")
public class RecipeResource {
    
    @Inject
    private RecipeRepository recipeRepository;
        
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }
}
