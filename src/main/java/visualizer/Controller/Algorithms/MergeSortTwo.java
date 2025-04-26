package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static visualizer.Commons.Commons.isSorted;
import static visualizer.Commons.Commons.less;

public class MergeSortTwo {

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

    public static void merge(int[] values1, int[] values2, int low, int middle, int high, List<List<Integer>> results) {
        isSorted(values1, low, middle, high);
        int[] merged = new int[values1.length + values2.length];
        System.arraycopy(values1, 0, merged, 0, values1.length);
        System.arraycopy(values2, 0, merged, values1.length, values2.length);
        results.add(Arrays.stream(merged).boxed().toList());
        if (high + 1 - low >= 0)
            System.arraycopy(values1, low, values2, low, high + 1 - low);
        int i = low;
        int j = middle + 1;
        for (int x = low; x <= high; x++)
            if (i > middle)
                values1[x] = values2[j++];
            else if (j > high)
                values1[x] = values2[i++];
            else if (less(values2[j], values2[i]))
                values1[x] = values2[j++];
            else
                values1[x] = values2[i++];
    }
}
