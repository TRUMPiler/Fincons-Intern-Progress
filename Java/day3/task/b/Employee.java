package day2.task.b;

// This class represents an employee and inherits properties from the Address class.
// This demonstrates an "is-a" relationship (inheritance).
public class Employee extends Address {

    String name;
    short age;
    int salary;

    // Constructor that initializes employee and address details by calling the superclass constructor.
    Employee(int salary, String name, short age, int id, String city, int pincode,String state) {
        super(city, pincode, state);
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Overridden toString method to include both employee and address information.
    @Override
    public String toString() {
        return "Employee{" +
                "address=" + super.toString()+
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}