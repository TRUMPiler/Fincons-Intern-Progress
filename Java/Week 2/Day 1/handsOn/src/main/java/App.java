import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        // Scanner for user input
        Scanner sc = new Scanner(System.in);
        try {
            // Service object to handle employee operations
            EmployeeService service = new EmployeeService();

            // Ask user for number of employees
            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();

            // Loop to collect employee details
            for (int i = 0; i < n; i++) {

                System.out.println("\nEnter Employee " + (i + 1) + " details:");

                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine(); // consume leftover newline

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Department: ");
                String department = sc.nextLine();

                System.out.print("Salary: ");
                double salary = sc.nextDouble();

                // Create Employee object and add it to service
                Employee employee = new Employee(id, name, department, salary);
                service.addEmployee(employee);
            }

            // Display all employees before filtering
            System.out.println("\n--- Employee List ---");
            for (Employee e : service.getAllEmployees()) {
                System.out.println(e);
            }
            // creating a filtered list of employees
            List<Employee> filteredList = service.getAllEmployees().stream()
                    .filter(e -> e.getSalary() > 40000)        // filter employees by salary
                    .peek(e -> e.setName(e.getName().toUpperCase())) // modify name ()
                    .toList();

            //printing the filtered list
            System.out.println("FilteredList:\n" + filteredList.stream().map(Employee::toString).collect(Collectors.joining("\n")));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data type.");
        } finally {
            //closing Scanner Resource
            sc.close();
        }
    }
}
