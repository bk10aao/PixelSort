package visualizer.Controller.Algorithms;

import java.util.List;

import static visualizer.Commons.Commons.initialize;
import static visualizer.Commons.Commons.merge;

public class MergeSortBottomUp {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = initialize(values);
        int[] aux = new int[values.length];
        for (int size = 1; size < values.length; size = 2 * size)
            for (int low = 0; low < values.length - size; low += 2 * size) {
                int mid = Math.min(low + size - 1, values.length - 1);
                int high = Math.min(low + 2 * size - 1, values.length - 1);
                merge(values, aux, low, mid, high, results);
            }
        return results;
    }
}
