package visualizer.Controller.Algorithms;

import java.util.List;

import static visualizer.Commons.Commons.initialize;
import static visualizer.Commons.Commons.merge;

public class MergeSortTopDown {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = initialize(values);
        int[] aux = new int[values.length];
        sort(values, aux, 0, values.length - 1, results);
        return results;
    }

    private static void sort(int[] values, int[] aux, int low, int high, List<List<Integer>> results) {
        if (high <= low)
            return;
        int mid = low + (high - low) / 2;
        sort(values, aux, low, mid, results);
        sort(values, aux, mid + 1, high, results);
        merge(values, aux, low, mid, high, results);
    }
}
