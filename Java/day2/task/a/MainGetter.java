package day2.task.a;

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
        Address address=new Address(city,pincode,state);
        Employee employee1=new Employee(address,salary,name,(short) age,1);
        System.out.println(employee1.toString());
    }
}
