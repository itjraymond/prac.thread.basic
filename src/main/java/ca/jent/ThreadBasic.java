package ca.jent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadBasic {

    public static void main(String[] args) {

        ThreadTask task1 = new ThreadTask("Task 1");
        ThreadTask task2 = new ThreadTask("Task 2");
        ThreadTask task3 = new ThreadTask("Task 3");

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);

        executorService.shutdown();
    }
}
