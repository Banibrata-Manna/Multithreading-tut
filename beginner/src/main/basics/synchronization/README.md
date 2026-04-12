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

## How to Run Tests
Since this is a standard project structure, you can run the tests through your IDE (IntelliJ IDEA) by right-clicking on the `src/test` folder and selecting **Run 'All Tests'**.