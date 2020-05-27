package lesson5;

public class HomeWork5 {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {

        // Create a one-dimensional long array
        float[] arr = new float[size];

        // Fill the array with "1"
        fillArray(arr);

        // Mark the time before starting to fill the array
        long a = System.currentTimeMillis();
        ordinaryMethod(arr);
        System.out.println("Execution time for ordinaryMethod: " + (System.currentTimeMillis() - a));

        fillArray(arr);
        a = System.currentTimeMillis();
        multiThreadsMethod(arr);
        System.out.println("Execution time for multiThreadsMethod: " + (System.currentTimeMillis() - a));
    }

    private static void fillArray(float[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 1;
        }
    }

    private static void ordinaryMethod(float[] a) {

        // Fill the array with new values using the formula
        for (int i = 0; i < a.length; i++) {
            a[i] = (float) (a[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void fillHalfArray(float[] a, int half) {

        for (int i = 0; i < a.length; i++) {
            a[i] = (float) (a[i] * Math.sin(0.2f + (i + half) / 5) *
                    Math.cos(0.2f + (i + half) / 5) * Math.cos(0.4f + (i + half) / 2));
        }
    }

    private static void multiThreadsMethod(float[] a) {

        // Split the array into two parts
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(a, 0, a1, 0, h);
        System.arraycopy(a, h, a2, 0, h);

        // Create two threads and fill the halfArrays with values using formula
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                HomeWork5.fillHalfArray(a1, 0);
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                HomeWork5.fillHalfArray(a2, h);
            }
        });
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Merge halfArrays
        System.arraycopy(a1, 0, a, 0, h);
        System.arraycopy(a2, 0, a, h, h);
    }
}
