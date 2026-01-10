package day2.handsOn;
class Department {
    int deptid;
    String deptname;
    public Department(int deptid, String deptname) {
        this.deptid = deptid;
        this.deptname = deptname;
    }

    public int getDeptid() {
        return deptid;
    }

    public String getDeptname() {
        return deptname;
    }
}