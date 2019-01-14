package ca.jent;

import java.security.SecureRandom;

public class ThreadTask implements Runnable {

    private static final SecureRandom generator = new SecureRandom();
    private final int sleepDuration;
    private final String taskName;

    public ThreadTask(String taskName) {
        this.taskName = taskName;
        sleepDuration = generator.nextInt(5000);
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s going to sleep for %d milliseconds.%n", taskName, sleepDuration);
            Thread.sleep(sleepDuration);

        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        System.out.printf("%s is done sleeping....%n", taskName);
    }

    /**
     * Typical execution result:
     *
     * > Task 1 going to sleep for 1724 milliseconds.
     * > Task 3 going to sleep for 2964 milliseconds.
     * > Task 2 going to sleep for 4843 milliseconds.
     * > Task 1 is done sleeping....
     * > Task 3 is done sleeping....
     * > Task 2 is done sleeping....
     *
     * > Process finished with exit code 0
     *
     */
}
