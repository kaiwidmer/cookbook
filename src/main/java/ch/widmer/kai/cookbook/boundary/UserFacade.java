package ch.widmer.kai.cookbook.boundary;

import java.util.Optional;

import javax.inject.Inject;

import ch.widmer.kai.cookbook.boundary.dto.UserDTO;
import ch.widmer.kai.cookbook.boundary.mapping.UserMapper;
import ch.widmer.kai.cookbook.domain.User;
import ch.widmer.kai.cookbook.repository.UserRepository;

public class UserFacade {
    
    @Inject
    private UserRepository userRepository;
    
    public Optional<UserDTO> getUser(String username, String password) {
        Optional<User> user = userRepository.getUser(username, password);
        if(user.isPresent()) {
            return Optional.of(UserMapper.INSTANCE.userToUserDTO(user.get()));
        }
        return Optional.empty();
    }
    
}
