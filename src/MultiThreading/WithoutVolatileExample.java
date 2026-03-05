package MultiThreading;

class SharedVariableCount{
    public boolean running = true;
}

public class WithoutVolatileExample {
    /*
     * WHY A THREAD MAY NOT SEE UPDATED VALUE (WITHOUT volatile)
     *
     * Even though multiple threads share the same object in heap memory,
     * visibility of changes between threads is NOT guaranteed unless
     * proper synchronization (volatile / synchronized / locks) is used.
     *
     * The issue is NOT only because of CPU core cache.
     * It involves multiple layers:
     *
     * ------------------------------------------------------------
     * 1) CPU CACHE (Hardware Level)
     * ------------------------------------------------------------
     * Modern CPUs have multiple cores, and each core has its own
     * local L1/L2 cache.
     *
     * If:
     *   - Thread A runs on Core 1
     *   - Thread B runs on Core 2
     *
     * Core 1 may cache a variable value locally.
     * Core 2 may update that value.
     *
     * Core 1 may continue reading its cached (stale) value
     * for some time unless memory barriers are used.
     *
     * Although CPUs use cache coherence protocols (like MESI),
     * visibility timing is NOT guaranteed without synchronization.
     *
     *
     * ------------------------------------------------------------
     * 2) CPU REGISTER OPTIMIZATION (Even on Same Core)
     * ------------------------------------------------------------
     * Even if both threads run on the SAME core,
     * the JVM may load a variable into a CPU register.
     *
     * Example:
     *   while (shared.running) { }
     *
     * The JVM may optimize this as:
     *
     *   boolean local = shared.running;
     *   while (local) { }
     *
     * Now the loop never re-reads memory.
     *
     * This is NOT a multi-core cache problem.
     * It is register-level optimization.
     *
     *
     * ------------------------------------------------------------
     * 3) JIT COMPILER OPTIMIZATION
     * ------------------------------------------------------------
     * The Java Memory Model allows the JVM to assume:
     *
     *   "If there is no synchronization, no other thread
     *    will modify this variable."
     *
     * So the JIT compiler is legally allowed to:
     *   - Move the read outside the loop
     *   - Cache the value
     *   - Reorder instructions
     *
     * This is valid behavior under Java Memory Model.
     *
     *
     * ------------------------------------------------------------
     * 4) JAVA MEMORY MODEL (Root Cause)
     * ------------------------------------------------------------
     * The fundamental issue is lack of a happens-before relationship.
     *
     * Without volatile or synchronization:
     *   - Writes from one thread are NOT guaranteed to be visible
     *     to another thread.
     *   - Reads may see stale values.
     *   - Instruction reordering is allowed.
     *
     * The infinite loop is allowed behavior under JMM.
     * It is NOT a JVM bug.
     *
     *
     * ------------------------------------------------------------
     * WHAT volatile DOES
     * ------------------------------------------------------------
     * Declaring a variable as volatile:
     *
     *   - Guarantees visibility across threads.
     *   - Prevents certain instruction reordering.
     *   - Inserts memory barriers (fences).
     *   - Forces reads to come from main memory.
     *   - Forces writes to be flushed to main memory.
     *
     * volatile establishes a happens-before relationship:
     *
     *   Write to volatile variable happens-before
     *   subsequent read of that same variable.
     *
     *
     * ------------------------------------------------------------
     * IMPORTANT CLARIFICATION
     * ------------------------------------------------------------
     * It is incorrect to say:
     *
     *   "The loop runs forever only because of core cache delay."
     *
     * The correct explanation is:
     *
     *   The loop may run forever because there is no
     *   happens-before relationship, allowing caching
     *   and reordering under the Java Memory Model.
     *
     *
     * ------------------------------------------------------------
     * SUMMARY
     * ------------------------------------------------------------
     * Without volatile:
     *   - Value may be cached in CPU cache.
     *   - Value may be cached in register.
     *   - JVM may optimize loop assuming no change.
     *   - Reordering is allowed.
     *   - Visibility is NOT guaranteed.
     *
     * With volatile:
     *   - Visibility is guaranteed.
     *   - Reordering is restricted.
     *   - Memory barriers are inserted.
     *
     */
    public static void main(String[] args) throws InterruptedException {
        SharedVariableCount sharedVariableCount = new SharedVariableCount();
        Runnable runnable = ()->{
            int count =0;
            while (sharedVariableCount.running){
                count++;
            }
            System.out.println("Count :"+count);
        };
        Thread thread = new Thread(runnable,"thread-1");
        thread.start();
        Thread.sleep(3000);
        sharedVariableCount.running=false;
    }

    // See WithVolatileExample.java
}
