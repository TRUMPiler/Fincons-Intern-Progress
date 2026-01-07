package day2.task.b;

public class Employee extends Address {
    Address address;
    String name;
    short age;

    int salary;
    Employee(int salary, String name, short age, int id, String city, int pincode,String state) {
        super(city, pincode, state);
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

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
