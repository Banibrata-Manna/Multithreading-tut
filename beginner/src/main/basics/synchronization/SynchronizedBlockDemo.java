package basics.synchronization;

public class SynchronizedBlockDemo {
    static void synchronizedIncrement(SynchronizedDemo synchronizedDemo) {
        synchronized (synchronizedDemo) {
            synchronizedDemo.increment();
        }
    }
}
