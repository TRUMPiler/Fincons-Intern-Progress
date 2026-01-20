
package com.fincons.day2.mapper;

import com.fincons.day2.dto.EmployeeDto;
import com.fincons.day2.entity.Employee;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting between Employee and EmployeeDto.
 */
@Component
public class EmployeeMapper {

    /**
     * Converts an Employee entity to an EmployeeDto.
     *
     * @param employee the Employee entity to convert.
     * @return the corresponding EmployeeDto.
     */
    public EmployeeDto toDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        return new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getSalary(),
                employee.getDepartment() != null ? employee.getDepartment().getId() : null
        );
    }

    /**
     * Converts an EmployeeDto to an Employee entity.
     *
     * @param employeeDto the EmployeeDto to convert.
     * @return the corresponding Employee entity.
     */
    public Employee toEntity(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        // Note: Department is not set here to avoid circular dependencies
        // and to be handled by the service layer.
        return employee;
    }
}
