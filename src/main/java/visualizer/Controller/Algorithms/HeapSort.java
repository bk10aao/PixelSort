package visualizer.Controller.Algorithms;

import visualizer.Commons.Commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static visualizer.Commons.Commons.exchange;
import static visualizer.Commons.Commons.sink;
import static visualizer.Commons.Commons.toList;


public class HeapSort {

    public static List<List<Integer>> sort(int[] values) {
        if (values == null || values.length <= 1) {
            List<List<Integer>> result = new ArrayList<>();
            if (values != null && values.length == 1)
                result.add(List.of(values[0]));
            return result;
        }
        List<List<Integer>> results = new ArrayList<>();
        int[] heap = new int[values.length + 1];
        System.arraycopy(values, 0, heap, 1, values.length);
        buildHeap(heap, values.length, results);
        results.add(toList(Arrays.copyOfRange(heap, 1, values.length)));
        sortDown(heap, values.length, results);
        return results;
    }

    private static void buildHeap(int[] heap, int size, List<List<Integer>> results) {
        for (int i = size / 2; i >= 1; i--)
            sink(heap, i, size, results);
    }

    private static void sortDown(int[] heap, int size, List<List<Integer>> results) {
        while (size > 1) {
            exchange(heap, 1, size--, results);
            sink(heap, 1, size, results);
            results.add(toList(Arrays.copyOfRange(heap, 1, heap.length)));
        }
    }
}
