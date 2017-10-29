package ch.widmer.kai.cookbook.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(
        name="user.getByUsernameAndPassword",
        query="Select u FROM User u where u.username = :username and u.password = :password"
    )
})
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String username;
    
    private String password;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String userName) {
        this.username = userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
