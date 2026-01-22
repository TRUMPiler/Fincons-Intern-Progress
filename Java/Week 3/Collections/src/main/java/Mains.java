import java.util.ArrayList;
import java.util.List;

class Employee
{
    int id;
    String Name;
    int salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee(int id, String name, int salary) {
        this.id = id;
        Name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
public class Mains {
    public static void main(String[] args) {
        List<Employee> naisal=new ArrayList<>();
        naisal.add(new Employee(1,"Naisal",1000));
        naisal.add(new Employee(2,"Naisal",2000));
        naisal.add(new Employee(3,"Naisal",3000));
        naisal.add(new Employee(4,"Naisal",4000));


        double filtersalary=3000;

        Employee emp=naisal.stream().filter(e->e.getSalary()>filtersalary).findFirst().orElseGet(()->new Employee(0,"Naisal",0));
        System.out.println(emp);
    }

}
