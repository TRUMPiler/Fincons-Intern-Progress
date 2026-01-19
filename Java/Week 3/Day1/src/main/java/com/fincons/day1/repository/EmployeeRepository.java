package com.fincons.day1.repository;

import com.fincons.day1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Spring Data JPA repository for the {@link Employee} entity.
 * This interface provides standard CRUD operations for employees.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    /**
     * Checks if an employee with the given email exists.
     *
     * @param email The email to check.
     * @return true if an employee with the given email exists, false otherwise.
     */
    boolean existsByEmail(String email);
}
