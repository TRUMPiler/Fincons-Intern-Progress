package com.fincons.day7.service.impl;

import com.fincons.day7.dto.TaskCreationDTO;
import com.fincons.day7.dto.TaskDTO;
import com.fincons.day7.entity.Task;
import com.fincons.day7.entity.User;
import com.fincons.day7.entity.enums.Status;
import com.fincons.day7.exception.InvalidTaskStatusException;
import com.fincons.day7.exception.TaskNotFoundException;
import com.fincons.day7.exception.UnauthorizedException;
import com.fincons.day7.exception.UserNotFoundException;
import com.fincons.day7.mapper.TaskMapper;
import com.fincons.day7.repository.TaskRepository;
import com.fincons.day7.repository.UserRepository;
import com.fincons.day7.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Implementation of the {@link TaskService} interface.
 * Handles the business logic for Task-related operations.
 */
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    /**
     * Constructs a new TaskServiceImpl with the given TaskRepository, UserRepository, and TaskMapper.
     * Dependencies are injected via constructor injection.
     *
     * @param taskRepository The repository for Task entities.
     * @param userRepository The repository for User entities.
     * @param taskMapper     The mapper for converting between Task entity and TaskDTO.
     */
    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.taskMapper = taskMapper;
    }

    /**
     * Creates a new task and assigns it to an existing user.
     * Validates if the user exists and if the task status is provided.
     *
     * @param userId          The ID of the user to whom the task will be assigned.
     * @param taskCreationDTO The TaskCreationDTO containing the details of the task to create.
     * @return The created TaskDTO.
     * @throws UserNotFoundException      if no user is found with the given userId.
     * @throws InvalidTaskStatusException if the task status in taskCreationDTO is null.
     */
    @Override
    public TaskDTO createTaskForUser(Long userId, TaskCreationDTO taskCreationDTO) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));

        if (taskCreationDTO.getStatus() == null) {
            throw new InvalidTaskStatusException("Task status cannot be null.");
        }

        Task task = new Task();
        task.setTitle(taskCreationDTO.getTitle());
        task.setStatus(taskCreationDTO.getStatus()); // Correctly assign the status from the DTO
        task.setUser(user); // Assign the found user to the task
        Task savedTask = taskRepository.save(task);
        return taskMapper.taskToTaskDTO(savedTask);
    }

    /**
     * Retrieves all tasks assigned to a specific user.
     *
     * @param userId The ID of the user whose tasks are to be retrieved.
     * @return A list of TaskDTOs assigned to the specified user.
     * @throws UserNotFoundException if no user is found with the given userId.
     */
    @Override
    public List<TaskDTO> getTasksByUserId(Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
        List<Task> tasks = taskRepository.findByUser(user);
        return tasks.stream()
                .map(taskMapper::taskToTaskDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all tasks that have a specific status.
     *
     * @param status The status (PENDING or COMPLETED) to filter tasks by.
     * @return A list of TaskDTOs with the specified status.
     * @throws InvalidTaskStatusException if the provided status is null.
     */
    @Override
    public List<TaskDTO> getTasksByStatus(Status status)
    {
        if (status == null)
        {
            throw new InvalidTaskStatusException("Status cannot be null for fetching tasks.");
        }
        List<Task> tasks = taskRepository.findByStatus(status);
        return tasks.stream()
                .map(taskMapper::taskToTaskDTO)
                .collect(Collectors.toList());
    }

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
    @Override
    public TaskDTO updateTask(Long userId, Long taskId, TaskDTO taskDTO) throws TaskNotFoundException, UnauthorizedException {
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + taskId));

        if (!Objects.equals(existingTask.getUser().getId(), userId)) {
            throw new UnauthorizedException("You are not authorized to update this task.");
        }

        existingTask.setTitle(taskDTO.getTitle()!=null?taskDTO.getTitle() : existingTask.getTitle());
        existingTask.setStatus(taskDTO.getStatus());

        Task updatedTask = taskRepository.save(existingTask);
        return taskMapper.taskToTaskDTO(updatedTask);
    }
}
