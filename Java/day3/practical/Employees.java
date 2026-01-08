class Employees
{
    private String name,department,emailId;
    private double salary;

    public Employees(String name, String department, String emailId, double salary) {
        this.name = name;
        this.department = department;
        this.emailId = emailId;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmailId() {
        return emailId;
    }

    public double getSalary() {
        return salary;
    }
}