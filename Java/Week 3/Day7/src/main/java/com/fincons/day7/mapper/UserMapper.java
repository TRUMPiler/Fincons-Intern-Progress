package com.fincons.day7.mapper;

import com.fincons.day7.dto.UserDTO;
import com.fincons.day7.entity.User;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between User entity and UserDTO.
 * Uses MapStruct to generate the implementation at compile time.
 * Configured as a Spring component for dependency injection.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {


    /**
     * Converts a User entity to a UserDTO.
     *
     * @param user The User entity to convert.
     * @return The converted UserDTO.
     */
    UserDTO userToUserDTO(User user);

    /**
     * Converts a UserDTO to a User entity.
     *
     * @param userDTO The UserDTO to convert.
     * @return The converted User entity.
     */
    User userDTOToUser(UserDTO userDTO);
}
