package com.fincons.day7;

/**
 * DTO for capturing employee filter criteria from URL query parameters (e.g., department).
 */
public class EmployeeFilterDto {

    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
