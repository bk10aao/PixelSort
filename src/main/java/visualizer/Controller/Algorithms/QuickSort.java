package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static visualizer.Commons.Commons.exchange;
import static visualizer.Commons.Commons.less;
import static visualizer.Commons.Commons.toList;

public class QuickSort {

    public static List<List<Integer>> sort(int[] values) {
        if(values == null)
            throw new NullPointerException();
        if(values.length == 0)
            throw new IllegalArgumentException();
        List<List<Integer>> results = new ArrayList<>();
        shuffle(values, results);
        sort(values, 0, values.length - 1, results);
        results.add(toList(values));
        return results;
    }

    private static void sort(int[] values, int low, int high, List<List<Integer>> results) {
        if(high <= low)
            return;
        results.add(Arrays.stream(values).boxed().toList());
        int j = partition(values, low, high, results);
        sort(values, low, j - 1, results);
        sort(values, j + 1, high, results);
    }

    private static int partition(int[] values, int low, int high, List<List<Integer>> results) {
        int leftPointer = low;
        int rightPointer = high + 1;
        while (true) {
            while(less(values[++leftPointer], values[low]))
                if (leftPointer == high)
                    break;
            while(less(values[low], values[--rightPointer]))
                if (rightPointer == low)
                    break;
            if(leftPointer >= rightPointer)
                break;
            exchange(values, leftPointer, rightPointer, results);
        }
        exchange(values, low, rightPointer, results);
        return rightPointer;
    }

    public static void shuffle(int[] values, List<List<Integer>> results) {
        Random rand = new Random();
        for (int i = values.length - 1; i > 0; i--)
            exchange(values, i, rand.nextInt(i + 1), results);
    }
}