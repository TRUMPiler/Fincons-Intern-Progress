
package com.fincons.day2.repository;

import com.fincons.day2.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

/**
 * Repository interface for managing departments in the database.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
}
