package handsOn;

/**
 * This class implements the Runnable interface to create a task for a thread.
 * It prints the thread's name, ID, and the process ID.
 */
public class MyThread implements Runnable
{


    /**
     * This method is the entry point for the new thread.
     * It prints the thread's name, ID, and the process ID.
     */
    @Override
    public void run()
    {

        long threadID= Thread.currentThread().threadId(),processid=ProcessHandle.current().pid();
        String Name=Thread.currentThread().getName();

        System.out.println("MyThread id:"+threadID+",process id:"+processid+",Name:"+Name);
    }
}
