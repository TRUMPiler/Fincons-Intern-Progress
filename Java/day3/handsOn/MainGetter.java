
import  java.util.*;

import  java.util.stream.*;
public class MainGetter
{
    public static void main(String[] args)
    {

        //Storing data of Employeees
        List<Employee> emp=new ArrayList();
        emp.add(new Employee("Riya","9326163059","naisaldoshi@gmail.com",2));
        emp.add(new Employee("Naisal","9326163059","naisaldoshi@gmail.com",1));
        emp.add(new Employee("Riya","9326163059","naisaldoshi@gmail.com",1));
        LinkedHashSet<Employee> filteredEmp=emp.stream()
        .sorted() //Sorting Based on CompareTo
        .distinct()// based on equals and hashCode
        .collect(Collectors.toCollection(LinkedHashSet::new));
        //printing values of employees
        for(Employee e:filteredEmp)
        {
           System.out.printf("id: %d name: %s PhoneNumber: %s email: %s%n", 
    e.hashCode(), 
    e.getName(), 
    e.getPhonenumber(), 
    e.getEmail());
        }
    }
}