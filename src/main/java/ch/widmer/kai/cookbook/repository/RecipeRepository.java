package ch.widmer.kai.cookbook.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ch.widmer.kai.cookbook.domain.Recipe;

public class RecipeRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Recipe> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Recipe> cq = cb.createQuery(Recipe.class);
        Root<Recipe> rootEntry = cq.from(Recipe.class);
        CriteriaQuery<Recipe> all = cq.select(rootEntry);
        TypedQuery<Recipe> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
}
