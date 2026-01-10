import java.util.*;
class Patterns
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of rows");
        int row=sc.nextInt();
        if(row<0)
        {
            throw new IllegalArgumentException("Number can't be less than zero");
        }
        int counter=0;
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