package com.fincons.day4.mapper;

import com.fincons.day4.dto.EmployeeDTO;
import com.fincons.day4.model.Employee;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO employeeToEmployeeDTO(Employee employee);
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);
//    public EmployeeDTO toDto(Employee employee) {
//        if (employee == null) {
//            return null;
//        }
//        return new EmployeeDTO(
//                employee.getId(),
//                employee.getName(),
//                employee.getEmail(),
//                employee.getSalary()
//        );
//    }
//
//    public Employee toEntity(EmployeeDTO employeeDTO) {
//        if (employeeDTO == null) {
//            return null;
//        }
//        return new Employee(
//                employeeDTO.getId(),
//                employeeDTO.getName(),
//                employeeDTO.getEmail(),
//                employeeDTO.getSalary()
//        );
//    }
}
