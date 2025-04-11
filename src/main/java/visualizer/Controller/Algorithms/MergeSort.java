package visualizer.Controller.Algorithms;

import visualizer.Commons.Commons;

import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static int[] aux;

    public static void sort(int[] a, List<List<Integer>> results) {
        aux = new int[a.length];
        int low = 0;
        int high = a.length - 1;
        sort(aux, a, low, high, results);
    }

    private static void sort(int[] values1, int[] values2, int low, int high, List<List<Integer>> results) {
        if (high <= low)
            return;
        int[] merged = new int[values1.length + values2.length];
        System.arraycopy(values1, 0, merged, 0, values1.length);
        System.arraycopy(values2, 0, merged, values1.length, values2.length);
        results.add(Arrays.stream(merged).boxed().toList());
        int mid = low + (high - low) / 2;
        sort(values1, values2, low, mid, results);
        sort(values1,values2, mid + 1, high, results);
        Commons.merge(values1, values2, low, mid, high);
    }
}