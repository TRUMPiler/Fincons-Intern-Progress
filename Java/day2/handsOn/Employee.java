package day2.hands-On;
class Employee
{
    private int eid;
    private String name;
    Department department;
    private double salary;

    public Employee(int eid, String name,Department department, double salary) {
        this.eid = eid;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary<0)
        {
            System.out.println("Salary is negative");
            this.setSalary(salary);

        }
        this.salary = salary;
    }
}