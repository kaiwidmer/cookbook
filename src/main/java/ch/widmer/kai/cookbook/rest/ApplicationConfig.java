package ch.widmer.kai.cookbook.rest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import ch.widmer.kai.cookbook.rest.security.AuthenticationFilter;

@ApplicationPath("/rest")
public class ApplicationConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> resourceClasses = new HashSet<>(Arrays.asList(StringResource.class, RecipeResource.class, AuthenticationResource.class));
        addOtherClasses(resourceClasses);
        return resourceClasses;
    }
    
    private void addOtherClasses(HashSet<Class<?>> resourceClasses) {
        resourceClasses.add(AuthenticationFilter.class);
    }
    
}
