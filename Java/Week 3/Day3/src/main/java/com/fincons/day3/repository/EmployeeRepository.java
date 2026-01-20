
package com.fincons.day3.repository;

import com.fincons.day3.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Handles database operations for the Employee entity.
 * Spring Data JPA provides the implementation for these methods automatically.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    public Optional<List<Employee>> findByDepartment(String name);
    public Optional<List<Employee>> findBySalaryGreaterThan(double salary);
}
