import java.util.*;

class PalindromChecker{
    public static boolean withStringBuilder(String key)
    {
        StringBuilder builder=new StringBuilder(key);
        builder.reverse();
        return key.equals(builder.toString());
        
    }
    public static boolean withLoop(String key)
    {
        int left=0,right=key.length()-1;
        while(left<right)
        {
            if(key.charAt(left)==key.charAt(right))
            {
                left++;
                right--;
                continue;
            }
            else
            {
                return false;
            }
            
        }
        return true;
    }
    public static void main(String args[])
    {
        String key="";
       if(args.length<1)
       {
            Scanner sc=new Scanner(System.in);
            key=sc.next();
            sc.close();
       }
       System.out.println("With loop:"+withLoop(key)+"\nwithStringBuilder:"+withStringBuilder(key));

    }
}