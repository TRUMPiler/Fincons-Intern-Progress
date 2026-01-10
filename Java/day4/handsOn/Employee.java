
public class Employee implements Comparable<Employee>
{
    //attributes of employee
    private String name,phonenumber,email;
    private int id;
    //constructor injector to inject values of all the attributes of Employee
    public Employee(String name,String phonenumber,String email,int id)
    {
        this.name=name;
        this.phonenumber=phonenumber;
        this.email=email;
        this.id=id;
    }
    //getter methods of all attributes
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

    @Override 
    public int compareTo(Employee e) //used for Sorting in sorted() of Stream api
    {
        
        return Integer.compare(this.id,e.getId());
    }

    @Override //used for distinct() to filter duplicates
    public boolean equals(Object object) {
        if (!(object instanceof Employee)) return false;
       
        Employee employee = (Employee) object;
        return getId() == employee.getId();
    }

    @Override //used for distinct() to filter duplicates
    public int hashCode() {
        return id;
    }
}