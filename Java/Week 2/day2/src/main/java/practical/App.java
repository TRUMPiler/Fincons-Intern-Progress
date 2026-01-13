package practical;

/**
 * This class is the main entry point for the application.
 * It demonstrates the creation and execution of threads using both
 * the `Thread` class and the `Runnable` interface.
 */
public class App {
    /**
     * The main method of the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a task by implementing Runnable
        Runnable runnableTask = new MyRunnableTask();

        // Create a task by extending Thread
        MyThreadTask myThreadTask = new MyThreadTask();

        // Create a thread from the Runnable task and name it
        Thread thread1 = new Thread(runnableTask,"MyRunnableTask");

        // Start the thread created by extending Thread
        myThreadTask.start();

        // Start the thread created from the Runnable task
        thread1.start();
    }
}
