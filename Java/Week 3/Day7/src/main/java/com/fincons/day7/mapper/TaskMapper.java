package com.fincons.day7.mapper;

import com.fincons.day7.dto.TaskDTO;
import com.fincons.day7.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper interface for converting between Task entity and TaskDTO.
 * Uses MapStruct to generate the implementation at compile time.
 * Configured as a Spring component for dependency injection.
 */
@Mapper(componentModel = "spring")
public interface TaskMapper {

    /**
     * Converts a Task entity to a TaskDTO.
     * Maps the user's ID from the Task entity to the userId field in TaskDTO.
     *
     * @param task The Task entity to convert.
     * @return The converted TaskDTO.
     */
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "status", target = "status")
    // Explicitly map the status field
    TaskDTO taskToTaskDTO(Task task);

    /**
     * Converts a TaskDTO to a Task entity.
     * The 'user' field in the Task entity is ignored during mapping as it will be set
     * separately in the service layer based on the userId from the TaskDTO.
     *
     * @param taskDTO The TaskDTO to convert.
     * @return The converted Task entity.
     */
    @Mapping(target = "user", ignore = true) // User will be set in service layer
    @Mapping(source = "status", target = "status")
    // Explicitly map the status field
    Task taskDTOToTask(TaskDTO taskDTO);
}
