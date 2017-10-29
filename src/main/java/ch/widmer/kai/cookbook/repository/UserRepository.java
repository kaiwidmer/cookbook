package ch.widmer.kai.cookbook.repository;

import java.util.Optional;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import ch.widmer.kai.cookbook.domain.User;

public class UserRepository extends Repository<User> {

    public UserRepository() {
        super(User.class);
    }
    
    public Optional<User> getUser(String userName, String password) {
        TypedQuery<User> query = entityManager.createNamedQuery("user.getByUsernameAndPassword", User.class);
        query.setParameter("username", userName);
        query.setParameter("password", password);
        try {
            return Optional.of(query.getSingleResult());
        } catch(NoResultException e) {
            return Optional.empty();
        }
    }
}
