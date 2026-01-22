package com.fincons.day5.mapper;

import com.fincons.day5.dto.EmployeeDTO;
import com.fincons.day5.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface for converting between Employee entity and EmployeeDTO.
 * This interface uses MapStruct to generate the implementation at compile time.
 * The {@code @Mapper(componentModel = "spring")} attribute makes the generated mapper a Spring component,
 * allowing it to be injected using {@code @Autowired}.
 */
@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    // This INSTANCE field is typically used when not integrating with a dependency injection framework like Spring.
    // With `componentModel = "spring"`, the mapper can be directly injected into other Spring components.
    // EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    /**
     * Converts an {@link Employee} entity to an {@link EmployeeDTO}.
     *
     * @param employee The Employee entity to convert.
     * @return The converted EmployeeDTO.
     */
    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    /**
     * Converts an {@link EmployeeDTO} to an {@link Employee} entity.
     *
     * @param employeeDTO The EmployeeDTO to convert.
     * @return The converted Employee entity.
     */
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);
}
