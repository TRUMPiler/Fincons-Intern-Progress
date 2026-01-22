package com.fincons.day5.repository;

import com.fincons.day5.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for {@link Employee} entities.
 * This interface extends {@link JpaRepository}, providing standard CRUD operations
 * and powerful querying capabilities for the Employee entity.
 * Spring Data JPA automatically generates the implementation for this interface at runtime.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Finds an employee by their email address.
     * Spring Data JPA will automatically generate the query for this method.
     *
     * @param email The email address of the employee to find.
     * @return An {@link Optional} containing the found Employee, or empty if no employee with the given email exists.
     */
    Optional<Employee> findByEmail(String email);
}
