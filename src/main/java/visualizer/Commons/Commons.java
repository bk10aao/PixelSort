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
}