package com.fincons.day7.repository;

import com.fincons.day7.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for User entities.
 * Extends JpaRepository to provide standard CRUD operations and custom query capabilities
 * for the User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Finds a User by their email address.
     *
     * @param email The email address of the user to find.
     * @return An Optional containing the User if found, or empty if not.
     */
    Optional<User> findByEmail(String email);

    /**
     * Executes a native SQL query to fetch user names along with the count of tasks
     * associated with each user.
     *
     * @return A List of Object arrays, where each array contains the user's name (String)
     * and the count of their tasks (Long).
     */
    @Query(value = "SELECT u.name, COUNT(t.id) FROM \"user\" u LEFT JOIN task t ON u.id = t.user_id GROUP BY u.id", nativeQuery = true)
    List<Object[]> findUserTaskCountsNative();
}
