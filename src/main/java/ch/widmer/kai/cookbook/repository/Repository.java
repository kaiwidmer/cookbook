package ch.widmer.kai.cookbook.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class Repository<T> {
    
    private Class<T> entityType;
    
    @PersistenceContext
    protected EntityManager entityManager;
    
    
    protected Repository(Class<T> entityType) {
        this.entityType = entityType;
    }
    
    public List<T> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityType);
        Root<T> rootEntry = cq.from(entityType);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
    
}
