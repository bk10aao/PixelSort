package visualizer.Controller.Algorithms;

import visualizer.Commons.Commons;

import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static int[] aux;

    public static List<List<Integer>> sort(int[] a, List<List<Integer>> results) {
        aux = new int[a.length];
        int low = 0;
        int high = a.length - 1;
        sort(aux, a, low, high, results);
        return results;
    }

    private static void sort(int[] values1, int[] values2, int low, int high, List<List<Integer>> results) {
        if (high <= low) return;
        int[] merged = new int[values1.length + values2.length];
        int index = 0;
        for(int i = 0;  i < values1.length; i++) {
            merged[index++] = values1[i];
        }
        for(int i = 0;  i < values2.length; i++) {
            merged[index++] = values2[i];
        }
        results.add(Arrays.stream(merged).boxed().toList());

        int mid = low + (high - low)/2;
        sort(values1, values2, low, mid, results);
        sort(values1,values2, mid+1, high, results);
        Commons.merge(values1, values2, low, mid, high);
    }
}