package visualizer.Controller.Algorithms;

import visualizer.Commons.Commons;

import java.util.ArrayList;
import java.util.List;

import static visualizer.Commons.Commons.less;

public class MergeSortTopDown {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = new ArrayList<>();
        int[] aux = new int[values.length];
        results.add(Commons.toList(values));
        sort(values, aux, 0, values.length - 1, results);
        results.add(Commons.toList(values));
        return results;
    }

    private static void sort(int[] values, int[] aux, int low, int high, List<List<Integer>> results) {
        if (high <= low)
            return;
        int mid = low + (high - low) / 2;
        sort(values, aux, low, mid, results);
        sort(values, aux, mid + 1, high, results);
        merge(values, aux, low, mid, high, results);
        results.add(Commons.toList(values));
    }

    private static void merge(int[] values, int[] aux, int low, int middle, int high, List<List<Integer>> results) {
        System.arraycopy(values, low, aux, low, high - low + 1);
        int i = low;
        int j = middle + 1;
        for (int k = low; k <= high; k++) {
            if (i > middle)
                values[k] = aux[j++];
            else if (j > high)
                values[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                values[k] = aux[j++];
            else
                values[k] = aux[i++];
            results.add(Commons.toList(values));
        }
    }
}
