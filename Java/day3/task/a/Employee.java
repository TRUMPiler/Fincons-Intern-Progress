package day2.task.a;

public class Employee {
    Address address;
    String name;
    short age;

    int salary;

    //
    Employee(Address address, int salary,String name, short age, int id) {
        this.address = address;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    //TO STRING METHOD TO PRINT VALUES OF ALL ATTRIBUTES
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
