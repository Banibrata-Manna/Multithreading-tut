package basics.synchronization;

public class SynchronizationProblem {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.start();
        System.out.println("Processor Started...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Setting number...");
        processor.number(89);
        System.out.println("Setting running...");
        processor.running(false);
    }
}

class Processor extends Thread {
    // Non Volatile fields
    private int number;
    private boolean running = true; // try making this volatile.

    public void run() {
        while (running) {
//            System.out.println("Number " + this.number);
        }
        System.out.println("=-=-=-=-= Thread " + number);
    }

    public void number(int number) {
        this.number = number;
    }

    public void running(boolean running) {
        this.running = running;
    }
}