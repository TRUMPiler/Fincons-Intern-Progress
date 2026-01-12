package day3.handsOn;

// This class represents a department with an ID and a name.
class Department {
    int deptid;
    String deptname;

    // Constructor to initialize the department's details.
    public Department(int deptid, String deptname) {
        this.deptid = deptid;
        this.deptname = deptname;
    }

    // Getter methods for the department's attributes.
    public int getDeptid() {
        return deptid;
    }

    public String getDeptname() {
        return deptname;
    }
}