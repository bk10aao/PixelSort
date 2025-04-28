package visualizer.Controller.Algorithms;// Java implementation of Introsort algorithm

import visualizer.Commons.Commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntroSort {

    private static final List<List<Integer>> results = new ArrayList<>();

    private static int[] values;

    private static void maxHeap(int i, int heap, int x) {
        int temp = values[x + i - 1];
        int child;

        while (i <= heap / 2) {
            child = 2 * i;
            if (child < heap && values[x + child - 1] < values[x + child])
                child++;
            if (temp >= values[x + child - 1])
                break;
            values[x + i - 1] = values[x + child - 1];
            i = child;
        }
        values[x + i - 1] = temp;
    }

    private static void heapify(int begin, int heapN) {
        for (int i = (heapN) / 2; i >= 1; i--)
            maxHeap(i, heapN, begin);
    }

    private static void heapSort(int begin, int end) {
        int heapN = end - begin;
        heapify(begin, heapN);
        for (int i = heapN; i >= 1; i--) {
            Commons.exchange(values, begin, begin + i);
            maxHeap(1, i, begin);
        }
    }

    private static void insertionSort(int left, int right) {
        for (int i = left; i <= right; i++) {
            int key = values[i];
            int j = i;
            while (j > left && values[j - 1] > key)
                values[j] = values[--j];
            values[j] = key;
        }
    }

    private static int findPivot(int x, int y, int z) {
        int max = Math.max(Math.max(values[x], values[y]), values[z]);
        int min = Math.min(Math.min(values[x], values[y]), values[z]);
        int median = max ^ min ^ values[x] ^ values[y] ^ values[z];
        if (median == values[x])
            return x;
        if (median == values[y])
            return y;
        return z;
    }

    private static int partition(int low, int high) {
        int pivot = values[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++)
            if (values[j] <= pivot)
                Commons.exchange(values, ++i, j);
        Commons.exchange(values,i + 1, high);
        return (i + 1);
    }

    private static void sortDataUtil(int begin, int end, int depthLimit) {
        if (end - begin > 16) {
            if (depthLimit == 0) {
                heapSort(begin, end);
                results.add(Arrays.stream(values).boxed().collect(Collectors.toList()));
                return;
            }
            depthLimit--;
            Commons.exchange(values, findPivot(begin, begin + ((end - begin) / 2) + 1, end), end);
            int p = partition(begin, end);
            sortDataUtil(begin, p - 1, depthLimit);
            sortDataUtil(p + 1, end, depthLimit);
        } else
            insertionSort(begin, end);
        results.add(Arrays.stream(values).boxed().collect(Collectors.toList()));
    }

    public static List<List<Integer>> sort(int[] arr) {
        values = arr;
        int size = values.length;
        int depthLimit = (int)(2 * Math.floor(Math.log(size) / Math.log(2)));
        sortDataUtil(0, size - 1, depthLimit);
        return results;
    }
}
