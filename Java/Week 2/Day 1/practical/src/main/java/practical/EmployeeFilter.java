package practical;

// A functional interface for defining conditions to filter employees.
@FunctionalInterface
public interface EmployeeFilter {
    // This method defines the condition for filtering an employee.
    boolean filter(Employee e);
}
