package visualizer.Commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Commons {

    public static void exchange(int[] values, int i, int j, List<List<Integer>> results) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        if (results != null) {
            results.add(Arrays.stream(values).boxed().collect(Collectors.toList()));
        }
    }

    public static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    public static void sink(int[] binaryHeap, int index, int n, List<List<Integer>> results) {
        while (2 * index <= n) {
            int j = 2 * index;
            if (j < n && Commons.less(binaryHeap[j], binaryHeap[j + 1]))
                j++;
            if (!Commons.less(binaryHeap[index], binaryHeap[j]))
                break;
            Commons.exchange(binaryHeap, index, j, results);
            index = j;
        }
    }

    public static List<Integer> toList(Integer[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static List<Integer> toList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static void recombine(Integer[] arr, Integer[] negative, Integer[] positive) {
        for(int i = negative.length - 1, j = 0; i >= 0; i--)
            arr[j++] = -negative[i];
        System.arraycopy(positive, 0, arr, negative.length, positive.length);
    }

    public static int getMaxDigits(Integer[] negative, Integer[] positive) {
        int maxNegative = 0;
        int maxPositive = 0;
        for(Integer i : positive)
            if (Commons.less(maxNegative, i))
                maxNegative = i;
        for(Integer i : negative)
            if (Commons.less(maxPositive, i))
                maxPositive = i;

        return maxNegative == 0 && maxPositive == 0 ? 0 : String.valueOf(Math.max(maxNegative, maxPositive)).length();
    }

    public static Integer[][] splitPositiveNegative(Integer[] array) {
        Map<Boolean, List<Integer>> split = Arrays.stream(array).collect(Collectors.partitioningBy(i -> i < 0));
        Integer[] negatives = split.get(true).stream().map(Math::abs).toArray(Integer[]::new);
        Integer[] positives = split.get(false).toArray(Integer[]::new);
        return new Integer[][]{negatives, positives};
    }

    public static void insertionSort(int[] values, int left, int right, List<List<Integer>> sortingStates) {
        for (int i = left + 1; i <= right; i++) {
            int temp = values[i];
            int j = i - 1;
            while (j >= left && values[j] > temp)
                values[j + 1] = values[j--];
            values[j + 1] = temp;
            sortingStates.add(toList(values));
        }
    }
}