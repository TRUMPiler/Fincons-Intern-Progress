package day2.task.b;

public class Employee extends Address {

    String name;
    short age;
    int salary;
    //constructor and calling super method that invokes Parent class Constructor
    Employee(int salary, String name, short age, int id, String city, int pincode,String state) {
        super(city, pincode, state);
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {// Generated to string method to print all values instead of printing each
        return "Employee{" +
                "address=" + super.toString()+
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
