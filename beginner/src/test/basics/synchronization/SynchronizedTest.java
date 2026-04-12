package basics.synchronization;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SynchronizedTest {
    // This case might fail sometimes, because 2000 iterations might be small to case race conditions sometimes, that's why kept the other tests iteration so large
    // I guess we can also try increasing number of threads, that might fail to!
    @Test
    public void testNonSynchronized() {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        try {
            Thread t1 = new Thread(() -> { for (int i = 0; i < 2000; i++) { synchronizedDemo.increment(); } });
            t1.start();
            Thread t2 = new Thread(() -> { for (int i = 0; i < 2000; i++) { synchronizedDemo.increment(); } });
            t2.start();
            t1.join();
            t2.join();
            assertNotEquals(4000, synchronizedDemo.getCount(), "Expected Result should be 4000");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    // This will always pass
    @Test
    public void testSynchronized() {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        try {
            Thread t1 = new Thread(() -> { for (int i = 0; i < 2000000; i++) { synchronizedDemo.synchronizedIncrement(); } });
            t1.start();
            Thread t2 = new Thread(() -> { for (int i = 0; i < 2000000; i++) { synchronizedDemo.synchronizedIncrement(); } });
            t2.start();
            t1.join();
            t2.join();
            assertEquals(4000000, synchronizedDemo.getCount(), "Expected Result should be 4000000");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSynchronized2() {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        try {
            Thread t1 = new Thread(() -> { for (int i = 0; i < 2000000; i++) { SynchronizedBlockDemo.synchronizedIncrement(synchronizedDemo); } });
            t1.start();
            Thread t2 = new Thread(() -> { for (int i = 0; i < 2000000; i++) { SynchronizedBlockDemo.synchronizedIncrement(synchronizedDemo); } });
            t2.start();
            t1.join();
            t2.join();
            assertEquals(4000000, synchronizedDemo.getCount(), "Expected Result should be 4000000");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
