
package com.fincons.day2.repository;

import com.fincons.day2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

/**
 * Handles database operations for the Employee entity.
 * Spring Data JPA provides the implementation for these methods automatically.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
