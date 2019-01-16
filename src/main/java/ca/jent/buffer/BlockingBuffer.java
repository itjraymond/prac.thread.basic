package ca.jent.buffer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Because the ArrayBlockingQueue implement the synchronization for us, we do not need to qualify our
 * mutating method along with the get.
 */
public class BlockingBuffer implements Buffer {

    private final ArrayBlockingQueue<Integer> buffer;

    public  BlockingBuffer() {
        buffer = new ArrayBlockingQueue<Integer>(1);
    }

    @Override
    public void put(int value) throws InterruptedException {
        buffer.put(value);
        System.out.printf("Producer writes %d.  buffer cell occupied: %d %n", value, buffer.size());
    }

    @Override
    public int get() throws InterruptedException {
        Integer value = buffer.take();
        System.out.printf("Consumer reads %d.  buffer cell occupied: %d %n", value, buffer.size());
        return value;
    }
}
