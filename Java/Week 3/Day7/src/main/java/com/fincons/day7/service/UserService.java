package com.fincons.day7.service;

import com.fincons.day7.dto.UserDTO;
import com.fincons.day7.exception.UserNotFoundException;

import java.util.List;

/**
 * Service interface for managing User-related operations.
 * Defines the business logic contract for user management.
 */
public interface UserService {
    /**
     * Creates a new user.
     *
     * @param userDTO The UserDTO containing the details of the user to create.
     * @return The created UserDTO.
     * @throws IllegalArgumentException if a user with the given email already exists.
     */
    UserDTO createUser(UserDTO userDTO);

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The UserDTO corresponding to the given ID.
     * @throws UserNotFoundException if no user is found with the given ID.
     */
    UserDTO getUserById(Long id) throws UserNotFoundException;

    /**
     * Retrieves a list of user names along with the count of tasks assigned to each user.
     * This uses a native SQL query.
     *
     * @return A List of Object arrays, where each array contains the user's name (String)
     * and the count of their tasks (Long).
     */
    List<Object[]> getUserTaskCounts();
}
