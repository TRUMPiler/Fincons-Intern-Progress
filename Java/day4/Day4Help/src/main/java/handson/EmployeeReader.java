package handson;

import java.util.*;
import java.io.*;
class EmployeeReader
{
    public static void main(String args[])
    {
        File file=new File("Employee.txt");
        Scanner sc=null;
        Map<String,String> empDetails=new HashMap<>();
        try
        {
            sc=new Scanner(file);
            
            while(sc.hasNextLine())
            {
                String data=sc.nextLine();
                String values[]=data.split(":");

                empDetails.put(values[0],values[1]);
                
            }
            if(empDetails.getOrDefault("Salary",null)==null)
            {
                System.out.println("Salary not found");
            }
            else
            {
               int datas= empDetails.get("Salary").contains("-") ? 1: 0;
               if(datas==1) throw new SalaryException("Salary Negative");
               else System.out.println("Salary is not Negative");
            }
            

        }
        catch(SalaryException se)
        {
            System.out.println("Error Salary Exception is invoked:"+se.getMessage());
        }
        catch(Exception e){
            System.out.println("Error Occurred:");
            e.printStackTrace();
        }
        finally
        {
            sc.close();
        }
    }
    
}