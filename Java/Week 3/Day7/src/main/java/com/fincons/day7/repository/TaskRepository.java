package com.fincons.day7.repository;

import com.fincons.day7.entity.Task;
import com.fincons.day7.entity.User;
import com.fincons.day7.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Task entities.
 * Extends JpaRepository to provide standard CRUD operations and custom query capabilities
 * for the Task entity.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    /**
     * Finds all tasks associated with a specific user.
     * This is a derived query based on the 'user' field in the Task entity.
     *
     * @param user The User entity whose tasks are to be found.
     * @return A List of Task entities belonging to the specified user.
     */
    List<Task> findByUser(User user);

    /**
     * Finds all tasks that have a specific status.
     * This is a derived query based on the 'status' field in the Task entity.
     *
     * @param status The Status enum value to filter tasks by.
     * @return A List of Task entities with the specified status.
     */
    List<Task> findByStatus(Status status);
}
