package com.fincons.day7.dto;

import com.fincons.day7.entity.Task; // Correct import for Task.Status
import com.fincons.day7.entity.enums.Status;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size; // Import for @Size annotation

/**
 * Data Transfer Object (DTO) for creating a new Task.
 * This DTO is used specifically for the task creation endpoint to ensure a clean API contract.
 * It includes validation annotations to ensure data integrity.
 */
public class TaskCreationDTO {
    /**
     * The title or description of the task. Cannot be empty and must be between 5 and 255 characters.
     */
    @NotEmpty(message = "Task title cannot be empty.")
    @Size(min = 5, max = 255, message = "Task title must be between 5 and 255 characters.")
    private String title;

    /**
     * The initial status of the task. Cannot be null.
     */
    @NotNull(message = "Task status cannot be null.")
    private Status status; // Correct usage of inner enum

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
