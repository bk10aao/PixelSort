package visualizer.Controller.Algorithms;

import visualizer.Commons.Commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static visualizer.Commons.Commons.exchange;
import static visualizer.Commons.Commons.toList;


public class HeapSort {

    public static List<List<Integer>> sort(int[] values) {
        if(values == null)
            throw new NullPointerException();
        if(values.length == 0)
            throw new IllegalArgumentException();
        List<List<Integer>> results = new ArrayList<>();
        results.add(toList(values));
        if(values.length == 1)
            return results;
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
            exchange(heap, 1, size--);
            sink(heap, 1, size, results);
            results.add(toList(Arrays.copyOfRange(heap, 1, heap.length)));
        }
    }
    public static void sink(int[] binaryHeap, int index, int n, List<List<Integer>> results) {
        while (2 * index <= n) {
            int j = 2 * index;
            if (j < n && Commons.less(binaryHeap[j], binaryHeap[j + 1]))
                j++;
            if (!Commons.less(binaryHeap[index], binaryHeap[j]))
                break;
            Commons.exchange(binaryHeap, index, j);
            results.add(Arrays.stream(binaryHeap).boxed().collect(Collectors.toList()));
            index = j;
        }
    }

}
