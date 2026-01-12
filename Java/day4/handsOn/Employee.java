package day4.handsOn;

// Represents an employee, designed for use in collections and streams.
// Implements Comparable for sorting and overrides equals/hashCode for uniqueness.
public class Employee implements Comparable<Employee> {
    private String name, phonenumber, email;
    private int id;

    // Constructor to initialize the employee's details.
    public Employee(String name, String phonenumber, String email, int id) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.id = id;
    }

    // Getter methods for employee attributes.
    public String getName() {
        return name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    // Compares employees by ID, enabling sorting.
    @Override
    public int compareTo(Employee e) {
        return Integer.compare(this.id, e.getId());
    }

    // Defines equality based on employee ID, used for finding distinct employees.
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Employee)) return false;
        Employee employee = (Employee) object;
        return getId() == employee.getId();
    }

    // Generates a hash code from the employee ID for efficient collection storage.
    @Override
    public int hashCode() {
        return id;
    }
}