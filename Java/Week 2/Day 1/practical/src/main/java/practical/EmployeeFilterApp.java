package practical;

import java.util.ArrayList;
import java.util.List;

// This application demonstrates filtering a list of employees based on dynamic conditions using lambda expressions.
public class EmployeeFilterApp {

    public static void main(String[] args) {
        // Create a list of employees to be used for filtering.
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 60000, "IT"));
        employees.add(new Employee("Jane Smith", 45000, "HR"));
        employees.add(new Employee("Peter Jones", 70000, "IT"));
        employees.add(new Employee("Mary Williams", 48000, "Finance"));
        employees.add(new Employee("David Brown", 52000, "IT"));

        System.out.println("Employees with salary > 50,000:");
        // Use a lambda expression to filter employees with a salary greater than 50,000.
        List<Employee> highSalaryEmployees = filterEmployees(employees, e -> e.getSalary() > 50000);
        highSalaryEmployees.forEach(System.out::println);

        System.out.println("\nEmployees from IT department:");
        // Use a lambda expression to filter employees who are in the "IT" department.
        List<Employee> itEmployees = filterEmployees(employees, e -> e.getDepartment().equals("IT"));
        itEmployees.forEach(System.out::println);
    }

    // This method filters a list of employees based on a given filter condition.
    static List<Employee> filterEmployees(List<Employee> employees, EmployeeFilter filter) {
        List<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (filter.filter(employee)) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }
}
