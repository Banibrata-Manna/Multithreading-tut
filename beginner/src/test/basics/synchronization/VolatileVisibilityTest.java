package basics.synchronization;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VolatileVisibilityTest {
    @Test
    void testVisibility() throws InterruptedException {
        VolatileVisibility example = new VolatileVisibility();
        example.startWorker();

        // Give the worker thread time to run
        Thread.sleep(100); 
        assertTrue(example.isRunning(), "Worker should be running initially");

        example.stopWorker();
        
        // Give the worker thread time to react to the flag change
        Thread.sleep(100); 
        assertFalse(example.isRunning(), "Worker should have stopped after flag change");
    }
}
