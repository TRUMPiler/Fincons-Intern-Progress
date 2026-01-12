import java.util.*;

// This class generates a triangular number pattern based on the number of rows entered by the user.
class Patterns
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of rows");
        int row=sc.nextInt();

        // Throws an exception if the number of rows is negative.
        if(row<0)
        {
            throw new IllegalArgumentException("Number can't be less than zero");
        }

        int counter=0;
        // Nested loops to print the triangular pattern.
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<i+1;++j)
            {
                System.out.print(++counter+" ");
            }
            System.out.println();
        }
    }
}