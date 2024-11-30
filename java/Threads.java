import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Threads {

    public static void main(String[] args) throws InterruptedException {
	int numTasks = 100000;
        if (args.length > 0) {
            numTasks = Integer.parseInt(args[0]);
        }

        List<Thread> threads = new LinkedList<>();

        Duration duration = Duration.ofSeconds(10);
        Runnable sleepRunnable = () -> {
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                // Handle exception
            }
        };

        for (int i = 0; i < numTasks; i++) {
            Thread thread = new Thread(sleepRunnable);
    	    thread.start();
            threads.add(thread);
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All fibers complete");
    }
}
