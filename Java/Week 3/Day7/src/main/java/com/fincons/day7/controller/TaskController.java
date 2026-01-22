package com.fincons.day7.controller;

import com.fincons.day7.dto.TaskCreationDTO;
import com.fincons.day7.dto.TaskDTO;
import com.fincons.day7.entity.Task;
import com.fincons.day7.entity.enums.Status;
import com.fincons.day7.exception.InvalidTaskStatusException;
import com.fincons.day7.exception.TaskNotFoundException;
import com.fincons.day7.exception.UnauthorizedException;
import com.fincons.day7.exception.UserNotFoundException;
import com.fincons.day7.service.TaskService;
import com.fincons.day7.utils.Response;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * REST Controller for managing Task-related operations.
 * Exposes endpoints for creating tasks, retrieving tasks by user, and fetching tasks by status.
 */
@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;

    /**
     * Constructs a new TaskController with the given TaskService.
     * Dependencies are injected via constructor injection.
     *
     * @param taskService The service for handling task business logic.
     */
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Creates a new task and assigns it to a specific user.
     * This endpoint follows the nested resource REST pattern.
     *
     * @param userId          The ID of the user to whom the task will be assigned.
     * @param taskCreationDTO The TaskCreationDTO containing the details of the task to create.
     * @return A ResponseEntity containing the created TaskDTO and HTTP status CREATED.
     */
    @PostMapping("/users/{userId}/tasks")
    public ResponseEntity<Object> createTaskForUser(@PathVariable Long userId, @Valid @RequestBody TaskCreationDTO taskCreationDTO) {
        TaskDTO createdTask = taskService.createTaskForUser(userId, taskCreationDTO);
        Response<TaskDTO> res = new Response<>(LocalDateTime.now(), "Task Created", HttpStatus.CREATED.value(), createdTask);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    /**
     * Retrieves all tasks assigned to a specific user.
     * This endpoint follows the nested resource REST pattern.
     *
     * @param userId The ID of the user whose tasks are to be retrieved.
     * @return A ResponseEntity containing a list of TaskDTOs and HTTP status OK.
     */
    @GetMapping("/users/{userId}/tasks")
    public ResponseEntity<Object> getTasksByUserId(@PathVariable Long userId) {
        List<TaskDTO> tasks = taskService.getTasksByUserId(userId);
        Response<List<TaskDTO>> res = new Response<>(LocalDateTime.now(), "Tasks Found", HttpStatus.OK.value(), tasks);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    /**
     * Retrieves all tasks that have a specific status.
     *
     * @param status The status (e.g., "PENDING", "COMPLETED") to filter tasks by.
     * @return A ResponseEntity containing a list of TaskDTOs and HTTP status OK.
     * @throws InvalidTaskStatusException if the provided status string is not a valid Task.Status enum value.
     */
    @GetMapping("/tasks/status/{status}")
    public ResponseEntity<Object> getTasksByStatus(@PathVariable String status) throws InvalidTaskStatusException {
        try {
            Status taskStatus = Status.valueOf(status.toUpperCase());
            List<TaskDTO> tasks = taskService.getTasksByStatus(taskStatus);
            Response<List<TaskDTO>> response = new Response<>(LocalDateTime.now(), "Tasks with status " + status + " found", HttpStatus.OK.value(), tasks);
            return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
        } catch (IllegalArgumentException e) {
            throw new InvalidTaskStatusException("Invalid task status: " + status + ". Allowed values are PENDING, COMPLETED.");
        }
    }

    /**
     * Updates an existing task for a specific user.
     * This endpoint follows the nested resource REST pattern.
     *
     * @param userId  The ID of the user who owns the task.
     * @param taskId  The ID of the task to update.
     * @param taskDTO The TaskDTO containing the updated details.
     * @return A ResponseEntity containing the updated TaskDTO and HTTP status OK.
     * @throws TaskNotFoundException if no task is found with the given taskId.
     * @throws UnauthorizedException if the task does not belong to the specified user.
     */
    @PutMapping("/users/{userId}/tasks/{taskId}")
    public ResponseEntity<Object> updateTask(@PathVariable Long userId, @PathVariable Long taskId, @Valid @RequestBody TaskDTO taskDTO) throws TaskNotFoundException, UnauthorizedException {
        TaskDTO updatedTask = taskService.updateTask(userId, taskId, taskDTO);
        Response<TaskDTO> res = new Response<>(LocalDateTime.now(), "Task Updated", HttpStatus.OK.value(), updatedTask);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
