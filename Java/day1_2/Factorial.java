import java.util.*;

// This class calculates the factorial of a given non-negative integer.
class Factorial {

    // Calculates the factorial of a number using an iterative approach.
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

    // Main method to get input and print the factorial of the number.
    public static void main(String args[]) {
        int intNum;

        // Fetches the number from command-line arguments or prompts the user for input.
        if (args.length < 1 || Integer.parseInt(args[0]) < 0) {
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

        // Calculates and prints the factorial if the number is non-negative.
        if (intNum >= 0) {
            System.out.println("Factorial of " + intNum + " is " + factorialGetter(intNum));
        } else {
            System.out.println("Factorial is not defined for negative numbers.");
        }
    }
}