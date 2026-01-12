import java.util.*;

class Factorial {
    public static long factorialGetter(int num) {   
        if (num < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }

        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void main(String args[]) {
        int intNum = 0;
        
        if (args.length < 1 || (args.length >= 1 && Integer.parseInt(args[0]) < 0)) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a non-negative integer: ");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid non-negative integer.");
                sc.next();
            }
            intNum = sc.nextInt();
            sc.close();
        } else {
            intNum = Integer.parseInt(args[0]);
        }

        if (intNum >= 0) {
            System.out.println("Factorial of " + intNum + " is " + factorialGetter(intNum));
        } else {
            System.out.println("Factorial is not defined for negative numbers.");
        }
    }
}
