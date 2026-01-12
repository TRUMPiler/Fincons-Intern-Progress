package day2.handsOn;

import java.util.Scanner;

class EmployeeSetter
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of employees data you want to explore: ");
        int n=sc.nextInt(),count=1;
        Employee[] e=new Employee[n];
        for(int i=0;i<n;i++)
        {

            System.out.print("Enter name of employee "+(i+1)+": ");
            String name=sc.next();
            System.out.print("Enter salary for employee "+(i+1)+": ");
            double salary=sc.nextDouble();
            System.out.print("Enter department name for employee "+(i+1)+": ");
            String deptname=sc.next();
            e[i]=new Employee(i+1,name,salary);
            int deptid=0;
            if(e[i].existingDepartmentChecker(deptname,e)==null) {
                deptid = count++;
                e[i].department=new Department(deptid,deptname);
            }
            else
            {
                e[i].department=e[i].existingDepartmentChecker(deptname,e);
            }

        }
        for(Employee e1: e)
        {
            System.out.print("id:"+e1.getEid());
            System.out.print("name:"+e1.getName());
            System.out.print("salary:"+e1.getSalary());
            System.out.print("department id"+e1.department.deptid);
            System.out.print("department name:"+e1.department.deptname);
            System.out.println();
        }
    }
}