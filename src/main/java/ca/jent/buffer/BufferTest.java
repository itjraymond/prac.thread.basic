package ca.jent.buffer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BufferTest {


    public static void main(String[] args) {

        Buffer buffer = new BlockingBuffer();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Producer(buffer));
        executorService.execute(new Consumer(buffer));

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
