import java.util.*;

// This class checks if a string is a palindrome using two different approaches.
class PalindromChecker{

    // Checks for a palindrome by reversing the string with StringBuilder.
    public static boolean withStringBuilder(String key)
    {
        StringBuilder builder=new StringBuilder(key);
        builder.reverse();
        return key.equals(builder.toString());
    }

    // Checks for a palindrome by comparing characters from both ends of the string.
    public static boolean withLoop(String key)
    {
        int left=0,right=key.length()-1;
        while(left<right)
        {
            if(key.charAt(left) != key.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Main method to get input and print the results of the palindrome checks.
    public static void main(String args[])
    {
        String key;
       if(args.length < 1)
       {
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter a string: ");
            key=sc.next();
            sc.close();
       } else {
           key = args[0];
       }
       System.out.println("With loop: " + withLoop(key));
       System.out.println("With StringBuilder: " + withStringBuilder(key));
    }
}