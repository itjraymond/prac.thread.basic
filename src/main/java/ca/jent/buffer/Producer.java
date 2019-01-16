package ca.jent.buffer;

import java.security.SecureRandom;

public class Producer implements Runnable {

    private Buffer buffer;
    private SecureRandom random = new SecureRandom();

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {

        try {
            for (int i=0; i < 10; i++) {
                Thread.sleep(random.nextInt(3000));
                buffer.put(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
