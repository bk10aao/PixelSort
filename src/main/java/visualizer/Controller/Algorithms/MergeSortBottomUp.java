package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static visualizer.Commons.Commons.*;
import static visualizer.Commons.Commons.less;

public class MergeSortBottomUp {

    public static List<List<Integer>> sort(int[] values) {
        if(values == null)
            throw new NullPointerException();
        if(values.length == 0)
            throw new IllegalArgumentException();
        List<List<Integer>> results = new ArrayList<>();
        results.add(toList(values));
        int n = values.length;
        int[] aux = new int[n];
        for (int size = 1; size < n; size = 2 * size) {
            for (int low = 0; low < n - size; low += 2 * size) {
                int mid = Math.min(low + size - 1, n - 1);
                int high = Math.min(low + 2 * size - 1, n - 1);
                merge(values, aux, low, mid, high, results);
            }
        }
        return results;
    }

    private static void merge(int[] values, int[] aux, int low, int middle, int high, List<List<Integer>> results) {
        System.arraycopy(values, low, aux, low, high + 1 - low);

        int i = low;
        int j = middle + 1;

        for (int k = low; k <= high; k++) {
            if (i > middle) {
                values[k] = aux[j++];
            } else if (j > high) {
                values[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                values[k] = aux[j++];
            } else {
                values[k] = aux[i++];
            }
            results.add(Arrays.stream(values).boxed().collect(Collectors.toList()));
        }

        results.add(Arrays.stream(values).boxed().collect(Collectors.toList()));
    }
}
