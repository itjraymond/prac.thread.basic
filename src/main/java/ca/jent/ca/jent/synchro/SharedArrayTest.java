package ca.jent.ca.jent.synchro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest {

    public static void main(String[] args) {

        SharedArray sharedArray = new SharedArray(8);

        ArrayWriter w1 = new ArrayWriter(1, sharedArray);
        ArrayWriter w2 = new ArrayWriter(10, sharedArray);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(w1);
        executorService.execute(w2);

        executorService.shutdown();

        try {
            boolean taskEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);

            if (taskEnded) {
                sharedArray.printIt();

            } else {
                System.out.println("Not enough time to finish computation....");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
