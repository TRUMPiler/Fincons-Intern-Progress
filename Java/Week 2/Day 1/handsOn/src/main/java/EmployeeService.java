import java.util.ArrayList;
import java.util.List;

// Service class to handle employee operations
public class EmployeeService {

    // List to store Employee objects
    private List<Employee> employees = new ArrayList<>();

    // Adds a new employee to the list

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Returns all stored employees

    public List<Employee> getAllEmployees() {
        return employees;
    }


}
