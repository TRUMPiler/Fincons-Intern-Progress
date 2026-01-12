package day4.practical;

// This class serves as a data model for an employee, holding their personal and professional details.
class Employees {
    private String name, department, emailId;
    private double salary;

    // Constructor to initialize an employee's details.
    public Employees(String name, String department, String emailId, double salary) {
        this.name = name;
        this.department = department;
        this.emailId = emailId;
        this.salary = salary;
    }

    // Getter methods to access the employee's attributes.
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmailId() {
        return emailId;
    }

    public double getSalary() {
        return salary;
    }
}