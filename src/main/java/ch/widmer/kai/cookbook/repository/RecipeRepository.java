package ch.widmer.kai.cookbook.repository;

import java.util.Optional;

import ch.widmer.kai.cookbook.domain.Recipe;
import ch.widmer.kai.cookbook.domain.User;

public class RecipeRepository extends Repository<Recipe> {
    
    public RecipeRepository() {
        super(Recipe.class);
    }
}
