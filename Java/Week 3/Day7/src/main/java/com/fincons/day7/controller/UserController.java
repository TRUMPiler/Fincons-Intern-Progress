package com.fincons.day7.controller;

import com.fincons.day7.dto.UserDTO;
import com.fincons.day7.exception.UserNotFoundException;
import com.fincons.day7.service.UserService;
import com.fincons.day7.utils.Response;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * REST Controller for managing User-related operations.
 * Exposes endpoints for creating users, retrieving user details, and fetching user task counts.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructs a new UserController with the given UserService.
     * Dependencies are injected via constructor injection.
     *
     * @param userService The service for handling user business logic.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Creates a new user.
     * The @Valid annotation triggers validation on the UserDTO.
     *
     * @param userDTO The UserDTO containing the details of the user to create.
     * @return A ResponseEntity containing the created UserDTO and HTTP status CREATED.
     */
    @PostMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        Response<UserDTO> response = new Response<>(LocalDateTime.now(), "User Created", HttpStatus.CREATED.value(), createdUser);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatusCode()));
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return A ResponseEntity containing the UserDTO and HTTP status OK.
     * @throws UserNotFoundException if no user is found with the given ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) throws UserNotFoundException {
        UserDTO userDTO = userService.getUserById(id);
        Response<UserDTO> response = new Response<>(LocalDateTime.now(), "User Found", HttpStatus.OK.value(), userDTO);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatusCode()));
    }

    /**
     * Retrieves a list of user names along with the count of tasks assigned to each user.
     *
     * @return A ResponseEntity containing a List of Object arrays (user name, task count) and HTTP status OK.
     */
    @GetMapping("/task-counts")
    public ResponseEntity<Object> getUserTaskCounts() {
        List<Object[]> userTaskCounts = userService.getUserTaskCounts();
        Response<List<Object[]>> response = new Response<>(LocalDateTime.now(), "User Task Counts Found", HttpStatus.OK.value(), userTaskCounts);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatusCode()));
    }
}
