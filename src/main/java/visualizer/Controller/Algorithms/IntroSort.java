package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.List;

import static visualizer.Commons.Commons.exchange;
import static visualizer.Commons.Commons.insertionSort;
import static visualizer.Commons.Commons.toList;

public class IntroSort {

    private static List<List<Integer>> results;

    public static List<List<Integer>> sort(int[] values) {
        if (values == null)
            throw new NullPointerException();
        if (values.length == 0)
            throw new IllegalArgumentException();

        results = new ArrayList<>();
        results.add(toList(values));

        int size = values.length;
        int depthLimit = (int) (2 * Math.floor(Math.log(size) / Math.log(2)));

        sortDataUtil(values, 0, size - 1, depthLimit);
        return results;
    }

    private static void sortDataUtil(int[] values, int begin, int end, int depthLimit) {
        if (end - begin > 16) {
            depthLimit--;
            int pivotIndex = findPivot(values, begin, begin + ((end - begin) / 2) + 1, end);
            exchange(values, pivotIndex, end);
            results.add(toList(values));
            int p = partition(values, begin, end);
            sortDataUtil(values, begin, p - 1, depthLimit);
            sortDataUtil(values, p + 1, end, depthLimit);
        } else
            insertionSort(values, begin, end, results);
        results.add(toList(values));
    }

    private static int partition(int[] values, int low, int high) {
        int pivot = values[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++)
            if (values[j] <= pivot)
                exchange(values, ++i, j, results);
        exchange(values, i + 1, high, results);
        return i + 1;
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
}