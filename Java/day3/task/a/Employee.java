package day2.task.a;

// This class represents an employee, containing personal and salary details.
// It holds an Address object, demonstrating a "has-a" relationship (composition).
public class Employee {
    Address address;
    String name;
    short age;
    int salary;

    // Constructor to initialize the employee's details, including their address.
    Employee(Address address, int salary,String name, short age, int id) {
        this.address = address;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Overridden toString method to provide a string representation of the employee's details.
    @Override
    public String toString() {
        return "Employee{" +
                "address=" + address +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}