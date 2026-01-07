package day2.task.b;

import java.util.Scanner;

public class MainGetter {
    public static void main(String[] args) {
        Employee employee;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your age: ");
        int age=sc.nextInt();
        if(age<18) {
            System.out.println("Invalid age");
        return;
        }
        System.out.println("Enter your salary: ");
        int salary = sc.nextInt();
        System.out.println("Enter your state: ");
        String state = sc.next();
        System.out.println("Enter your city: ");
        String city = sc.next();
        System.out.println("Enter your pincode: ");
        int pincode = sc.nextInt();

        Employee employee1=new Employee(salary,name,(short) age,1,city,pincode,state);
        System.out.println(employee1.toString());
    }
}
