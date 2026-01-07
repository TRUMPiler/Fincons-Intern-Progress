package day2.handsOn;
class Employee
{
    private int eid;
    private String name;
    public Department department;
    private double salary;

    public Employee(int eid, String name, double salary) {
        this.eid = eid;
        this.name = name;
        this.department = null;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(int id,String name) {
        this.department = new Department(id,name);
    }
    public Department existingDepartmentChecker(String deptname,Employee[] emp)
    {
        if(emp==null||emp.length==0) return null;
        int i=0;
        for(Employee e:emp)
        {
            if(e==null||e.department==null) return null;

            if(e.department.getDeptname().equals(deptname))
            {
                return e.department;
            }

        }
        return null;
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