
package com.fincons.day3.dto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
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
    @Positive(message = "Salary must be a positive value")
    private double salary;

    /**
     * The ID of the department to which the employee belongs.
     */
    private String departmentName;


    /**
     *  overriding the equals and hashcode method for .distinct()
     *  to make the list distinct when comparing
     * @param o   the reference object with which to compare.
     * @return the equivalent list of
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return  Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSalary(), getDepartmentName());
    }
}
