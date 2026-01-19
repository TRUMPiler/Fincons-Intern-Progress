
package com.fincons.day2.repository;

import com.fincons.day2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

/**
 * Repository interface for managing employees in the database.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
