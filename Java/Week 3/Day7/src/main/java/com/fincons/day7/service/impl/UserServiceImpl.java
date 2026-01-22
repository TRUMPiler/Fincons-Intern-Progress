package com.fincons.day7.service.impl;

import com.fincons.day7.dto.UserDTO;
import com.fincons.day7.entity.User;
import com.fincons.day7.exception.UserNotFoundException;
import com.fincons.day7.mapper.UserMapper;
import com.fincons.day7.repository.UserRepository;
import com.fincons.day7.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link UserService} interface.
 * Handles the business logic for User-related operations.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    /**
     * Constructs a new UserServiceImpl with the given UserRepository and UserMapper.
     * Dependencies are injected via constructor injection.
     *
     * @param userRepository The repository for User entities.
     * @param userMapper     The mapper for converting between User entity and UserDTO.
     */
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * Creates a new user in the system.
     * Validates if a user with the provided email already exists.
     *
     * @param userDTO The UserDTO containing the details of the user to create.
     * @return The created UserDTO.
     * @throws IllegalArgumentException if a user with the given email already exists.
     */
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User with this email already exists.");
        }
        User user = userMapper.userDTOToUser(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDTO(savedUser);
    }

    /**
     * Retrieves a user by their unique ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The UserDTO corresponding to the given ID.
     * @throws UserNotFoundException if no user is found with the given ID.
     */
    @Override
    public UserDTO getUserById(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return userMapper.userToUserDTO(user);
    }

    /**
     * Retrieves a list of user names along with the count of tasks assigned to each user.
     * This method delegates to a native SQL query defined in the UserRepository.
     *
     * @return A List of Object arrays, where each array contains the user's name (String)
     * and the count of their tasks (Long).
     */
    @Override
    public List<Object[]> getUserTaskCounts() {
        return userRepository.findUserTaskCountsNative();
    }
}
