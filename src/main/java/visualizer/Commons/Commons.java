package visualizer.Commons;

import java.util.Random;

public class Commons {
    public static void exchange(int[] values, int i, int j) {
        int swap = values[i];
        values[i] = values[j];
        values[j] = swap;
    }

    public static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    public static void shuffle(int[] values) {
        Random rand = new Random();
        for (int i = values.length - 1; i > 0; i--)
            Commons.exchange(values, i, rand.nextInt(i + 1));
    }

    public static void merge(int[] values1, int[] values2, int low, int middle, int high) {
        isSorted(values1, low, middle, high);
        if (high + 1 - low >= 0) System.arraycopy(values2, low, values1, low, high + 1 - low);
        int i = low;
        int j = middle + 1;
        for (int x = low; x <= high; x++) {
            if (i > middle) values2[x] = values1[j++];
            else if (j > high) values2[x] = values1[i++];
            else if (less(values1[j], values1[i])) values2[x] = values1[j++];
            else values2[x] = values1[i++];
        }
    }

    public static void isSorted(int[] values1, int low, int middle, int high) {
        assert Commons.isSorted(values1, low, middle);
        assert Commons.isSorted(values1, middle + 1, high);
    }

    public static boolean isSorted(int[] values, int low, int high) {
        for (int i = low + 1; i <= high; i++)
            if (less(values[i], values[i - 1])) return false;
        return true;
    }
}