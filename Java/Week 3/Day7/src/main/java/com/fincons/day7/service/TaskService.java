package com.fincons.day7.service;

import com.fincons.day7.dto.TaskCreationDTO;
import com.fincons.day7.dto.TaskDTO;
import com.fincons.day7.entity.Task;
import com.fincons.day7.entity.enums.Status;
import com.fincons.day7.exception.TaskNotFoundException;
import com.fincons.day7.exception.UnauthorizedException;
import com.fincons.day7.exception.UserNotFoundException;

import java.util.List;

/**
 * Service interface for managing Task-related operations.
 * Defines the business logic contract for task management.
 */
public interface TaskService {
    /**
     * Creates a new task and assigns it to an existing user.
     *
     * @param userId          The ID of the user to whom the task will be assigned.
     * @param taskCreationDTO The TaskCreationDTO containing the details of the task to create.
     * @return The created TaskDTO.
     * @throws UserNotFoundException                                 if no user is found with the given userId.
     * @throws com.fincons.day7.exception.InvalidTaskStatusException if the task status is null.
     */
    TaskDTO createTaskForUser(Long userId, TaskCreationDTO taskCreationDTO) throws UserNotFoundException;

    /**
     * Retrieves all tasks assigned to a specific user.
     *
     * @param userId The ID of the user whose tasks are to be retrieved.
     * @return A list of TaskDTOs assigned to the specified user.
     * @throws UserNotFoundException if no user is found with the given userId.
     */
    List<TaskDTO> getTasksByUserId(Long userId) throws UserNotFoundException;

    /**
     * Retrieves all tasks that have a specific status.
     *
     * @param status The status (PENDING or COMPLETED) to filter tasks by.
     * @return A list of TaskDTOs with the specified status.
     * @throws com.fincons.day7.exception.InvalidTaskStatusException if the provided status is null.
     */
    List<TaskDTO> getTasksByStatus(Status status);

    /**
     * Updates an existing task.
     * Verifies that the task exists and belongs to the specified user before updating.
     *
     * @param userId  The ID of the user who owns the task.
     * @param taskId  The ID of the task to update.
     * @param taskDTO The TaskDTO containing the updated details.
     * @return The updated TaskDTO.
     * @throws TaskNotFoundException if no task is found with the given taskId.
     * @throws UnauthorizedException if the task does not belong to the specified user.
     */
    TaskDTO updateTask(Long userId, Long taskId, TaskDTO taskDTO) throws TaskNotFoundException, UnauthorizedException;
}
