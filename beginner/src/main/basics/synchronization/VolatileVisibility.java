package basics.synchronization;

/**
 * Demonstrates the importance of the 'volatile' keyword for visibility.
 * One thread reads the flag while another updates it.
 */
public class VolatileVisibility {
    // Without volatile, the reading thread might cache the value and never see the update
    private boolean running = true;

    public void startWorker() {
        System.out.println("Worker thread starting...");
        
        Thread workerThread = new Thread(() -> {
            long count = 0;
            while (running) {
                count++;
                // Busy-waiting to demonstrate visibility switch
            }
            System.out.println("Worker thread stopped. Count: " + count);
        });
        
        workerThread.start();
    }

    public void stopWorker() {
        System.out.println("Stopping worker...");
        running = false;
    }

    public boolean isRunning() {
        return running;
    }
}
