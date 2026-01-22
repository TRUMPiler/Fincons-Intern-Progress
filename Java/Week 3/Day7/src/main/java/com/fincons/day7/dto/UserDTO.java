package com.fincons.day7.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size; // Import for @Size annotation

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
     * The name of the user. Cannot be empty and must be between 2 and 100 characters.
     */
    @NotEmpty(message = "User name cannot be empty.")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters.")
    private String name;
    /**
     * The email address of the user. Cannot be empty, must be a valid email format, and cannot exceed 255 characters.
     */
    @NotEmpty(message = "User email cannot be empty.")
    @Email(message = "Email should be valid.")
    @Size(max = 255, message = "Email cannot exceed 255 characters.")
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
