package ca.jent.synchro;

import java.security.SecureRandom;

class SharedArray {

    private final int[] list;  // shared data
    private int writeIndex = 0;
    private SecureRandom random = new SecureRandom();


    SharedArray(int size) {
        this.list = new int[size];
    }

    // This is the method that MODIFIES the shared array.  If you do not put the synchronized keyword, it will shows
    // that the shared array will have inconsistent data.
    synchronized void add(int value) {
        int position = writeIndex;
        try {
            Thread.sleep(random.nextInt(3000));

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // we add the value at the current poistion
        list[position] = value;
        // we increment the writeIndex
        writeIndex++;
        System.out.printf("Wrote %d at index %d %n", value, position);
        System.out.printf("Next write index is %d %n", writeIndex);
    }

    void printIt() {
        System.out.print("[ ");
        String comma = "";

        for (int i = 0; i < list.length; i++) {

            System.out.print( comma + list[i]);
            comma = ", ";
        }
        System.out.print(" ]");
    }


}
