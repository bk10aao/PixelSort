package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static visualizer.Commons.Commons.exchange;
import static visualizer.Commons.Commons.insertionSort;

public class IntroSort {


    private static List<List<Integer>> results;

    public static List<List<Integer>> sort(int[] values) {
        results = new ArrayList<>();
        int size = values.length;
        int depthLimit = (int)(2 * Math.floor(Math.log(size) / Math.log(2)));
        sortDataUtil(values,0, size - 1, depthLimit);
        return results;
    }

    private static void maxHeap(int[] values, int i, int heap, int x) {
        int temp = values[x + i - 1];
        int child;

        while (i <= heap / 2) {
            child = 2 * i;
            if (child < heap && values[x + child - 1] < values[x + child])
                child++;
            if (temp >= values[x + child - 1])
                break;
            values[x + i - 1] = values[x + child - 1];
            results.add(Arrays.stream(values).boxed().collect(Collectors.toList()));
            i = child;
        }
        values[x + i - 1] = temp;
        results.add(Arrays.stream(values).boxed().collect(Collectors.toList()));
    }

    private static void heapify(int[] values, int begin, int heapN) {
        for (int i = (heapN) / 2; i >= 1; i--)
            maxHeap(values, i, heapN, begin);
    }

    private static void heapSort(int[] values, int begin, int end) {
        int heapN = end - begin;
        heapify(values, begin, heapN);
        for (int i = heapN; i > 1; i--) {
            exchange(values, begin, begin + i - 1, results);
            maxHeap(values,1, i - 1, begin);
        }
    }

    private static int findPivot(int[] values, int x, int y, int z) {
        int max = Math.max(Math.max(values[x], values[y]), values[z]);
        int min = Math.min(Math.min(values[x], values[y]), values[z]);
        int median = max ^ min ^ values[x] ^ values[y] ^ values[z];
        if (median == values[x])
            return x;
        if (median == values[y])
            return y;
        return z;
    }

    private static int partition(int[] values, int low, int high) {
        int pivot = values[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++)
            if (values[j] <= pivot)
                exchange(values, ++i, j, results);
        exchange(values,i + 1, high, results);
        return (i + 1);
    }

    private static void sortDataUtil(int[] values, int begin, int end, int depthLimit) {
        if (end - begin > 16) {
            if (depthLimit == 0) {
                heapSort(values, begin, end);
                return;
            }
            depthLimit--;
            exchange(values, findPivot(values, begin, begin + ((end - begin) / 2) + 1, end), end, results);
            int p = partition(values, begin, end);
            sortDataUtil(values, begin, p - 1, depthLimit);
            sortDataUtil(values, p + 1, end, depthLimit);
        } else
            insertionSort(values, begin, end, results);
    }
}
