package basics.synchronization;

public class SynchronizedDemo {
    private int count = 0;

    void increment() {
        count = count + 1;
    }

    synchronized void synchronizedIncrement() {
        count = count + 1;
    }

    public int getCount() {
        return count;
    }
}
