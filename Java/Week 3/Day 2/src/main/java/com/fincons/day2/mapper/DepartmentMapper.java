
package com.fincons.day2.mapper;

import com.fincons.day2.dto.DepartmentDto;
import com.fincons.day2.entity.Department;
import com.fincons.day2.entity.Employee;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

/**
 * Mapper for converting between Department and DepartmentDto.
 */
@Component
public class DepartmentMapper {

    /**
     * Converts a Department entity to a DepartmentDto.
     *
     * @param department the Department entity to convert.
     * @return the corresponding DepartmentDto.
     */
    public DepartmentDto toDto(Department department) {
        if (department == null) {
            return null;
        }
        return new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getEmployees() != null ?
                        department.getEmployees().stream().map(Employee::getId).collect(Collectors.toList()) :
                        null
        );
    }

    /**
     * Converts a DepartmentDto to a Department entity.
     *
     * @param departmentDto the DepartmentDto to convert.
     * @return the corresponding Department entity.
     */
    public Department toEntity(DepartmentDto departmentDto) {
        if (departmentDto == null) {
            return null;
        }
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setName(departmentDto.getName());
        // Please Note Riya: Employees are not set here to avoid circular dependencies
        // and to be handled by the service layer as you taught me.
        return department;
    }
}
