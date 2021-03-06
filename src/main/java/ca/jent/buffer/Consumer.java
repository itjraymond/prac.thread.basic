package ca.jent.buffer;

import java.security.SecureRandom;

public class Consumer implements Runnable {

    SecureRandom random = new SecureRandom();
    Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

        try {
            for (int i=0; i < 10; i++) {
                Thread.sleep(random.nextInt(3000));
                int value = buffer.get();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
