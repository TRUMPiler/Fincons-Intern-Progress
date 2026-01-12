import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MainsGetter{
    //method to iterate for getting details and handelling null;
    static Employees details(int id,Map<Integer, Employees> map)
    {
            if(map.getOrDefault(id,null)!=null)
            {
                return map.get(id);
            }
            return null;
    }

    public static void main(String args[])
    {
        Map<Integer,Employees> employees = new HashMap<Integer,Employees>();//storing data accoring to id of all employees
        Scanner input = new Scanner(System.in);
        for(int i=0;i<5;i++)
        {
            System.out.println("Enter Employee Department");// enter department
            String deptname=input.next();
            System.out.println("Enter Employee Name");// enter name
            String name=input.next();
            System.out.println("Enter Employee Salary"); //enter salary
            double salary=input.nextDouble();
            if(salary<0) // salary cant be less than 0
            {
                System.out.println("salary can't be negative\nre-enter the details");
                i--;
                continue;
            }
            System.out.println("Enter Employee Email");
            String email=input.next();
            employees.put(i,new Employees(name,deptname,email,salary));// constructors inejections
        }
        int choice=2;
        while(choice!=0)// repeating menu
        {
            System.out.println("Choice 1 for searching employees details and Choice 0 for exit\nEnter choice");
            choice=input.nextInt();
            if(choice==1)
            {
                System.out.println("Enter Employee id");
                int id=input.nextInt();
                Employees e=details(id,employees); //getting values from details
                if(e==null)
                {
                    System.out.println("Details not found");
                    continue;
                }
                System.out.println("name:"+e.getName()+" salary:"+e.getSalary()+" departname:"+e.getDepartment()+" email:"+e.getEmailId());
            }
            else
            {
                System.out.println("wrong choice");
            }
        }
    }
}