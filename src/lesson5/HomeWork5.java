package lesson5;

public class HomeWork5 {

    static final int size = 10000000;
    static final int h = size / 2;

    private static void ordinaryMethod() {

        // Create a one-dimensional long array
        float[] arr = new float[size];

        // Fill the array with "1"
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        // Mark the time before starting to fill the array
        long a = System.currentTimeMillis();

        // Fill the array with new values using the formula
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        // Mark the time after filling the array
        long b = System.currentTimeMillis();
        System.out.println(b -a);
    }

    private static void multipleThreadsMethod() {

        // Create a one-dimensional long array
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        // Fill the array with "1"
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        // Mark the time before starting to fill the array
        long a = System.currentTimeMillis();

        // Splitting the array into two parts
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
    }

    public static void main(String[] args) {
        ordinaryMethod();
    }
}
