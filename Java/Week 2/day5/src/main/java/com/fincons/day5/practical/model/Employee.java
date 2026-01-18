package com.fincons.day5.practical.model;

/**
 * I created this class to represent one of my employees.
 */
public class Employee {

    // The employee's ID, which I'll use to identify them.
    private long id;
    // The employee's name.
    private String name;
    // The department where the employee works.
    private String department;

    /**
     * I'll use this to create new Employee objects.
     * @param id The employee's ID.
     * @param name The employee's name.
     * @param department The employee's department.
     */
    public Employee(long id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    /**
     * I'll use this to get an employee's ID.
     * @return The employee's ID.
     */
    public long getId() {
        return id;
    }

    /**
     * I'll use this to set an employee's ID.
     * @param id The new ID for the employee.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * I'll use this to get an employee's name.
     * @return The employee's name.
     */
    public String getName() {
        return name;
    }

    /**
     * I'll use this to set an employee's name.
     * @param name The new name for the employee.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * I'll use this to get an employee's department.
     * @return The employee's department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * I'll use this to set an employee's department.
     * @param department The new department for the employee.
     */
    public void setDepartment(String department) {
        this.department = department;
    }
}
