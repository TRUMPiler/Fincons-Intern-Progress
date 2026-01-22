package com.fincons.day7.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

/**
 * Data Transfer Object (DTO) for User.
 * Used to transfer user data between layers, especially for API responses and requests,
 * providing a cleaner separation from the entity model.
 * Includes validation annotations to ensure data integrity.
 */
public class UserDTO {
    /**
     * The unique identifier of the user.
     */
    private Long id;
    /**
     * The name of the user. Cannot be empty.
     */
    @NotEmpty(message = "User name cannot be empty.")
    private String name;
    /**
     * The email address of the user. Cannot be empty and must be a valid email format.
     */
    @NotEmpty(message = "User email cannot be empty.")
    @Email(message = "Email should be valid.")
    private String email;
    /**
     * The active status of the user.
     */
    private boolean active;
    /**
     * A list of tasks associated with this user.
     * Included for displaying tasks when fetching user details.
     */
    private List<TaskDTO> tasks;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }
}
