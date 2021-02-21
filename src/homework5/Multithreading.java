package homework5;

import java.util.Arrays;

public class Multithreading {
    public static final int SIZE = 10000000;
    public static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        doWithMultithreading();
        doWithoutMultithreading();

    }

    private static void doWithoutMultithreading() {
        float[] array = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = 1f;
        }
        long before = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            float f = (float) i;
            array[i] = (float) (array[i] * Math.sin(0.2f + f / 5) * Math.cos(0.2f + f / 5) * Math.cos(0.4f + f / 2));
        }
        long after = System.currentTimeMillis();
        System.out.println("Время без использования многопоточности: " + (after - before));

    }

    private static void doWithMultithreading() {
        float[] array = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = 1f;
        }
        long before = System.currentTimeMillis();
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        System.arraycopy(array, 0, arr1, 0, HALF);
        System.arraycopy(array, HALF, arr2, 0, HALF);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++) {
                    float f = (float) i;
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + f / 5) * Math.cos(0.2f + f / 5) * Math.cos(0.4f + f / 2));
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                float z=HALF;
                for (int i = 0; i < HALF; i++,z++) {
                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + z / 5) * Math.cos(0.2f + z / 5) * Math.cos(0.4f + z / 2));
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr1, 0, array, 0, HALF);
        System.arraycopy(arr2, 0, array, HALF, HALF);
        long after = System.currentTimeMillis();
        System.out.println("Время с использованием многопоточности:" + (after - before));

    }
}
