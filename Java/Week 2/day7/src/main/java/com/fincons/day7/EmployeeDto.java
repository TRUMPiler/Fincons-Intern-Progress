package com.fincons.day7;

import lombok.Data;
import lombok.Getter;

@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private String department;
    private Double salary;

}
