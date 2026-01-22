package com.fincons.migratedday4.mapper;

import com.fincons.migratedday4.dto.EmployeeDTO;
import com.fincons.migratedday4.model.Employee;
import org.mapstruct.Mapper;

/**
 * This Mapper class maps:
 * {@link Employee}  to {@link EmployeeDTO}
 * And
 * {@link EmployeeDTO} to {@link Employee}
 */
@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO employeeToEmployeeDTO(Employee employee);
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);

}
