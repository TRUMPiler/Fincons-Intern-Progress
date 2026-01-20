
package com.fincons.day2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

/**
 * Data Transfer Object for Department.
 * This class is used to transfer department data between the client and the server.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    /**
     * The unique identifier for the department.
     */
    private UUID id;

    /**
     * The name of the department.
     */
    private String name;

    /**
     * A list of employee IDs belonging to the department.
     */
    private List<UUID> employeeIds;
}
