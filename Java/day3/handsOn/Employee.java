package day3.handsOn;

// This class represents an employee with contact details and an ID.
// It implements Comparable for sorting and overrides equals and hashCode for uniqueness in collections.
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

    // Getter methods for the employee's attributes.
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

    // Compares employees based on their ID for sorting purposes.
    @Override
    public int compareTo(Employee e) {
        return Integer.compare(this.id, e.getId());
    }

    // Checks for equality between two Employee objects based on their ID.
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Employee)) return false;
        Employee employee = (Employee) object;
        return getId() == employee.getId();
    }

    // Generates a hash code for the Employee object based on its ID.
    @Override
    public int hashCode() {
        return id;
    }
}