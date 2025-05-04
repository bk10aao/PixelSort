package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static visualizer.Commons.Commons.isSorted;
import static visualizer.Commons.Commons.less;

public class MergeSortBottomUp {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = new ArrayList<>();
        int n = values.length;
        int[] aux = new int[n];
        for (int size = 1; size < n; size = 2 * size)
            for (int low = 0; low < n - size; low += 2 * size)
                merge(values, aux, low, low + size - 1, Math.min(low + size + size - 1, n - 1), results);
        results.add(Arrays.stream(values).boxed().collect(Collectors.toList()));
        return results;
    }

    private static void merge(int[] values, int[] aux, int low, int middle, int high, List<List<Integer>> results) {
        isSorted(values, low, middle, high);
        for (int i = low; i <= high; i++)
            aux[i] = values[i];
        int i = low;
        int j = middle + 1;
        for (int k = low; k <= high; k++)
            if (i > middle)
                values[k] = aux[j++];
            else if (j > high)
                values[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                values[k] = aux[j++];
            else
                values[k] = aux[i++];
        results.add(Arrays.stream(values).boxed().collect(Collectors.toList()));
    }
}
