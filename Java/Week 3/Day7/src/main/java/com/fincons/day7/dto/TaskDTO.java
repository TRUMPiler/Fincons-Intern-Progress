package com.fincons.day7.dto;

import com.fincons.day7.entity.enums.Status;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Data Transfer Object (DTO) for Task.
 * Used to transfer task data between layers, especially for API responses and requests,
 * providing a cleaner separation from the entity model.
 * Includes validation annotations to ensure data integrity.
 */
public class TaskDTO {
    /**
     * The unique identifier of the task.
     */
    private Long id;
    /**
     * The title or description of the task. Cannot be empty.
     */

    private String title;
    /**
     * The current status of the task (PENDING or COMPLETED). Cannot be null.
     */
    @NotNull(message = "Task status cannot be null.")
    private Status status;
    /**
     * The ID of the user to whom this task is assigned.
     * This links the task to a user without exposing the full UserDTO object within the TaskDTO.
     */
    private Long userId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
