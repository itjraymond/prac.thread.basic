package ca.jent.buffer;

/**
 * DON'T DO THIS:  only for educational/knowledge purpose (use an ArrayBlockingQueue or LinkedListBlockingQueue).
 * This buffer is synchronized "manually" and its sole purpose is to demo the mechanics of how to use the keyword
 * synchronized
 * Code come from
 */
public class SynchronizedBuffer implements Buffer {

    private int buffer = -1; // shared by  producer and consumer threads
    private boolean occupied = false;

    /**
     * If a Thread calls this method, no other Thread can call any "synchronized methods" on this object.
     * Hence, a Thread executing this will block the get() until it is relinquished or finished.
     * @param value
     * @throws InterruptedException
     */
    @Override
    public synchronized void put(int value) throws InterruptedException {
        while(occupied) {
            System.out.println("Producer tries to write.");
            wait();  // relinquish the object monotor lock to allow other thread to execute other methods on this object.
        }
        System.out.printf("Producer writes value %d.%n", value);
        buffer = value;
        occupied = true;
        notifyAll();
    }

    /**
     * If a Thread calls this method, no other Thread can call any "synchronized methods" on this object.
     * Hence, a Thread executing this will block the put() until it is relinquished or finished.
     * @param value
     * @throws InterruptedException
     */
    @Override
    public synchronized int get() throws InterruptedException {
        while(!occupied) {
            System.out.println("Consumer tries to read.");
            wait();
        }
        System.out.printf("Consumer reads value %d.%n", buffer);
        occupied = false;
        notifyAll();
        return buffer;
    }
}
