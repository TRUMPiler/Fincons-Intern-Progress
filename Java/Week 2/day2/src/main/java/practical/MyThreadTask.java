package practical;

/**
 * This class demonstrates the creation of a thread by extending the Thread class.
 */
public class MyThreadTask extends Thread{
    /**
     * This method is the entry point for the new thread.
     * It prints the thread's name and numbers from 0 to 4.
     */
    @Override
    public void run()
    {
        String Name=Thread.currentThread().getName();
        for(int i=0;i<5;i++)
        {
            System.out.println("MyThreadTask:"+Name+",printing number:"+i);
        }
    }
}
