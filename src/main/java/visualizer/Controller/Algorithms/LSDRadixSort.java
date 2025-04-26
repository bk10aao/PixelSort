package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import visualizer.Commons.Commons;

public class LSDRadixSort {

    public static List<List<Integer>> sort(Integer[] arr) {
        List<List<Integer>> sortingStates = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return sortingStates;

        saveState(arr, sortingStates);
        Map<Boolean, List<Integer>> split = Arrays.stream(arr).collect(Collectors.partitioningBy(i -> i < 0));
        Integer[] negative = split.get(true).stream().map(Math::abs).toArray(Integer[]::new);
        Integer[] positive = split.get(false).toArray(Integer[]::new);

        int maxDigits = getMaxDigits(negative, positive);

        for (int exp = 1; maxDigits > 0; exp *= 10, maxDigits--) {
            if (negative.length > 0)
                countSort(negative, exp);
            if (positive.length > 0)
                countSort(positive, exp);
            recombine(arr, negative, positive);
            saveState(arr, sortingStates);
        }

        return sortingStates;
    }

    private static void countSort(Integer[] arr, int exp) {
        Integer[] output = new Integer[arr.length];
        int[] digitCounts = new int[10];

        Arrays.stream(arr).forEach(value -> digitCounts[(value / exp) % 10]++);
        IntStream.range(1, 10).forEach(i -> digitCounts[i] += digitCounts[i - 1]);

        for (int i = arr.length - 1; i >= 0; i--) {
            Integer current = arr[i];
            int digit = (current / exp) % 10;
            output[--digitCounts[digit]] = current;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }


    private static void saveState(Integer[] arr, List<List<Integer>> sortingStates) {
        sortingStates.add(Commons.toList(arr));
    }

    private static int getMaxDigits(Integer[] positive, Integer[] negative) {
        int maxNeg = 0, maxPos = 0;
        for (Integer value : positive)
            if (Commons.less(maxNeg, value))
                maxNeg = value;
        for (int value : negative)
            if (Commons.less(maxPos, value))
                maxPos = value;
        return maxNeg == 0 && maxPos == 0 ? 0 : String.valueOf(Math.max(maxNeg, maxPos)).length();
    }

    private static void recombine(Integer[] arr, Integer[] negative, Integer[] positive) {
        for (int i = negative.length - 1, j = 0; i >= 0; i--)
            arr[j++] = -negative[i];
        System.arraycopy(positive, 0, arr, negative.length, positive.length);
    }
}
