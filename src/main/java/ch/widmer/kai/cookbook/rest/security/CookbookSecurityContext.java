package ch.widmer.kai.cookbook.rest.security;

import java.security.Principal;
import java.util.List;

import javax.ws.rs.core.SecurityContext;

public class CookbookSecurityContext implements SecurityContext{

    private String username;
    private List<String> groups;

    public CookbookSecurityContext(String username, List<String> groups) {
        this.username = username;
        this.groups = groups;
    }

    @Override
    public String getAuthenticationScheme() {
        return AuthenticationFilter.AUTHENTICATION;
    }

    @Override
    public Principal getUserPrincipal() {
        return new Principal() {
            @Override
            public String getName() {
                return username;
            }
        };
    }

    @Override
    public boolean isSecure() {
        return true;
    }

    @Override
    public boolean isUserInRole(String role) {
        return groups.contains(role);
    }
}
