package basics.synchronization;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DualVariableVisibilityTest {
    @Test
    void testMemoryBarrier() throws InterruptedException {
        DualVariableVisibility example = new DualVariableVisibility();

        Thread readerThread = new Thread(() -> {
            // Busy poll until 'ready' becomes true
            while (!example.isReady()) {
                // Spinning
            }
            // Once 'ready' is true, nonVolatileValue must be visible as 42
            assertEquals(42, example.getNonVolatileValue(), 
                "Non-volatile value must be 42 due to happens-before relationship.");
        });

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(50); // Ensure reader starts polling first
                example.writer();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        readerThread.start();
        writerThread.start();

        writerThread.join();
        readerThread.join();
    }
}
