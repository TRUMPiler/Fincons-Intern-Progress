package com.fincons.day1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for employee data.
 * Used for transferring employee information between layers.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO{
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;

}
