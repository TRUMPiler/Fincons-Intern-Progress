package com.example.model;

// This class defines the structure for an Employee object.
public class Employee {
    // The employee's ID is final because it should not be changed.
    private final int id;
    private String name;
    private String department;
    private double salary;

    // Constructor to create a new employee instance.
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getter for the employee's ID.
    public int getId() {
        return id;
    }

    // Getter for the employee's name.
    public String getName() {
        return name;
    }

    // Setter for the employee's name.
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the employee's department.
    public String getDepartment() {
        return department;
    }

    // Setter for the employee's department.
    public void setDepartment(String department) {
        this.department = department;
    }

    // Getter for the employee's salary.
    public double getSalary() {
        return salary;
    }

    // Setter for the employee's salary.
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Provides a string representation of the employee, useful for printing.
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
