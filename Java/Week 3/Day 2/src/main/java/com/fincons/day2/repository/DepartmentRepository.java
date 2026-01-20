
package com.fincons.day2.repository;

import com.fincons.day2.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Handles database operations for the Department entity.
 * Spring Data JPA provides the implementation for these methods automatically.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
    Optional<Department> findByName(String name);
}
