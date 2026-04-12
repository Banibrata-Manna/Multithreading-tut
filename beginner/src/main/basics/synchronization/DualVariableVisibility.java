package basics.synchronization;

/**
 * Demonstrates the "Happens-Before" relationship (Memory Barrier).
 * Writing to a volatile variable ensures that all previous writes 
 * (even to non-volatile variables) are visible to other threads 
 * that subsequently read the same volatile variable.
 */
public class DualVariableVisibility {
    private int nonVolatileValue = 0;
    private volatile boolean ready = false;

    public void writer() {
        nonVolatileValue = 42; // Step 1: Write to non-volatile
        ready = true;          // Step 2: Write to volatile (Memory Barrier)
    }

    public void reader() {
        if (ready) {           // Step 3: Read from volatile (Memory Barrier)
            // If ready is true, then nonVolatileValue is GUARANTEED to be 42
            // because of the Happens-Before relationship established by Step 2 and 3.
            // Try changing the order of step 1 and 2, that will fail the test.
            System.out.println("Non-volatile value read: " + nonVolatileValue);
        } else {
            System.out.println("Flag not set yet.");
        }
    }

    public boolean isReady() {
        return ready;
    }

    public int getNonVolatileValue() {
        return nonVolatileValue;
    }
}
