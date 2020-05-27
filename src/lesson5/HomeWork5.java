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
        System.out.println("Execution time: " + (System.currentTimeMillis() - a));

        fillArray(arr);
        a = System.currentTimeMillis();
        multipleThreadsMethod();
        System.out.println("Execution time: " + (System.currentTimeMillis() - a));
    }

    private static void fillArray(float[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 1;
        }
    }

    private static void ordinaryMethod(float[] a) {

        // Fill the array with new values using the formula
        for (int i = 0; i < size; i++) {
            a[i] = (float) (a[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        // Mark the time after filling the array
        long b = System.currentTimeMillis();

    }

    private static void multipleThreadsMethod() {

        // Create a one-dimensional long array and two split arrays
        float[] arr = new float[size];

        // Fill the array with "1"
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        // Mark the time before starting to fill the array
        long a = System.currentTimeMillis();

        // Create two threads
        Runnable r = new Runnable() {
            @Override
            public void run() {
                fillArrays(arr);
                long b = System.currentTimeMillis();
                System.out.println(b - a);
            }
        };

        new Thread(r, "Thread#1").start();
        new Thread(r, "Thread#2").start();
    }

    private static synchronized void fillArrays(float[] a) {

        // Split the array into two parts
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(a, 0, a1, 0, h);
        System.arraycopy(a, h, a2, 0, h);

        // Fill the arrays with new values using the formula and two threads
        for (int i = 0; i < h; i++) {
            a1[i] = (float) (a[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        for (int i = 0; i < h; i++) {
            a2[i] = (float) (a[i + 500_000] * Math.sin(0.2f + (i + 500_000)/ 5) *
                    Math.cos(0.2f + (i + 500_000)/ 5) * Math.cos(0.4f + (i + 500_000)/ 2));
        }

        // Merge arrays
        System.arraycopy(a1, 0, a, 0, h);
        System.arraycopy(a2, 0, a, h, h);
    }
}
