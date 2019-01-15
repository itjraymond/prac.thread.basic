package ca.jent.ca.jent.synchro;

/**
 * You can have serveral ArrayWriter that will write values to a shared array.  ** NOT THREAD SAFE
 */
public class ArrayWriter implements Runnable {

    private final SharedArray sharedArray;
    private final int startValue;

    public ArrayWriter(int startValue, SharedArray sharedArray) {
        this.startValue = startValue;
        this.sharedArray = sharedArray;
    }

    @Override
    public void run() {

        for (int i=startValue; i < startValue + 4; i++) {
            sharedArray.add(i);
        }

    }
}
