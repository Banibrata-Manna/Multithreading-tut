# Thread Synchronization Concepts

This project demonstrates core thread synchronization concepts in Java, organized into a standard source and test structure.

## Project Structure

- `src/main`: Contains the core logic classes.
- `src/test`: Contains test cases that demonstrate and verify multithreading behavior.

## Core Concepts

### 1. Visibility (The `volatile` Keyword)
The `volatile` keyword ensures that changes to a variable are visible across all threads.

- **Example**: [VolatileVisibility.java](file:///Users/banibratamanna/siksha/java/multithreading/beginner/src/main/basics/synchronization/VolatileVisibility.java)
- **Test Case**: [VolatileVisibilityTest.java](file:///Users/banibratamanna/siksha/java/multithreading/beginner/src/test/basics/synchronization/VolatileVisibilityTest.java)

### 2. Memory Barrier (Happens-Before)
Writing to a `volatile` variable flushes all previous writes (even non-volatile ones) to main memory. Reading a `volatile` variable refreshes subsequent reads.

- **Example**: [DualVariableVisibility.java](file:///Users/banibratamanna/siksha/java/multithreading/beginner/src/main/basics/synchronization/DualVariableVisibility.java)
- **Test Case**: [DualVariableVisibilityTest.java](file:///Users/banibratamanna/siksha/java/multithreading/beginner/src/test/basics/synchronization/DualVariableVisibilityTest.java)

### 3. Mutual Exclusion (Intrinsic Locks)
Every object in Java has an **intrinsic lock** (also called a **monitor** or **mutex**). When a thread invokes a synchronized method, it automatically acquires the intrinsic lock for that method's object and releases it when the method returns.

- **Atomicity**: Only one thread can acquire the lock at a time. If another thread attempts to call a synchronized method on the same object, it will block (suspend execution) until the first thread releases the lock.
- **Visibility**: Synchronization also ensures that changes made to the state of the object are visible to all threads that subsequently acquire the same lock, providing the same visibility guarantees as the `volatile` keyword.

- **Example**: [SynchronizedDemo.java](file:///Users/banibratamanna/siksha/java/multithreading/beginner/src/main/basics/synchronization/SynchronizedDemo.java)
- **Test Case**: [SynchronizedTest.java](file:///Users/banibratamanna/siksha/java/multithreading/beginner/src/test/basics/synchronization/SynchronizedTest.java)


## How to Run Tests
Since this is a standard project structure, you can run the tests through your IDE (IntelliJ IDEA) by right-clicking on the `src/test` folder and selecting **Run 'All Tests'**.