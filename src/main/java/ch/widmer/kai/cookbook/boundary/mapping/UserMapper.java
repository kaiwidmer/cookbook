 package ch.widmer.kai.cookbook.boundary.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ch.widmer.kai.cookbook.boundary.dto.UserDTO;
import ch.widmer.kai.cookbook.domain.User;

@Mapper
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    
    UserDTO userToUserDTO(User user);
    
}
