package day3.handsOn;

import java.util.Scanner;

// This class handles the creation and display of employee and department data.
class EmployeeSetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        int deptIdCounter = 1;

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            // Gathering employee and department details from the user.
            System.out.print("Enter name of employee " + (i + 1) + ": ");
            String name = sc.next();
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            double salary = sc.nextDouble();
            System.out.print("Enter department name for employee " + (i + 1) + ": ");
            String deptName = sc.next();

            employees[i] = new Employee(i + 1, name, salary);

            // Logic to check for and reuse existing departments.
            Department existingDept = employees[i].existingDepartmentChecker(deptName, employees);
            if (existingDept == null) {
                employees[i].department = new Department(deptIdCounter++, deptName);
            } else {
                employees[i].department = existingDept;
            }
        }

        // Displaying the details of each employee and their assigned department.
        for (Employee emp : employees) {
            System.out.println("ID: " + emp.getEid() + ", Name: " + emp.getName() + ", Salary: " + emp.getSalary() +
                    ", Dept ID: " + emp.department.deptid + ", Dept Name: " + emp.department.deptname);
        }
    }
}