
package com.fincons.day2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

/**
 * Data Transfer Object for Employee.
 * This class is used to transfer employee data between the client and the server.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    /**
     * The unique identifier for the employee.
     */
    private UUID id;

    /**
     * The name of the employee.
     */
    private String name;

    /**
     * The salary of the employee.
     */
    private double salary;

    /**
     * The ID of the department to which the employee belongs.
     */
    private UUID departmentId;
}
