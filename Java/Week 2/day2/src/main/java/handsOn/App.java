package handsOn;

/**
 * This class is the main entry point for the application.
 * It demonstrates the creation and execution of multiple threads from a single Runnable task.
 */
public class App {
    /**
     * The main method of the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a single Runnable task
        Runnable threads=new MyThread();

        // Create three threads from the same Runnable task
      Thread t1 = new Thread(threads,"Task Naisal 1");

      Thread t2 = new Thread(threads,"Task Naisal 2");


      Thread t3 = new Thread(threads,"Task Naisal 3");


        // Start the threads
        t2.start();
        t3.start();
        t1.start();

    }
}
