package visualizer.Controller.Algorithms;

import visualizer.Commons.Commons;
import java.util.ArrayList;
import java.util.List;

public class HeapSort {

    public static List<List<Integer>> sort(int[] array) {
        if (array == null || array.length <= 1) {
            List<List<Integer>> result = new ArrayList<>();
            if (array != null && array.length == 1)
                result.add(List.of(array[0]));
            return result;
        }
        List<List<Integer>> result = new ArrayList<>();
        int[] heap = new int[array.length + 1];
        System.arraycopy(array, 0, heap, 1, array.length);
        buildHeap(heap, array.length);
        result.add(Commons.toList(heap, 1, array.length));
        sortDown(heap, array.length, result);
        System.arraycopy(heap, 1, array, 0, array.length);
        return result;
    }

    private static void buildHeap(int[] heap, int size) {
        for (int i = size / 2; i >= 1; i--)
            Commons.sink(heap, i, size);
    }

    private static void sortDown(int[] heap, int size, List<List<Integer>> result) {
        while (size > 1) {
            Commons.exchange(heap, 1, size--); // Swap max with last element
            Commons.sink(heap, 1, size);      // Restore heap property
            result.add(Commons.toList(heap, 1, heap.length - 1));
        }
    }
}
