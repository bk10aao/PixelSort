package visualizer.Controller.Algorithms;

import visualizer.Commons.Commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static visualizer.Commons.Commons.getMaxDigits;
import static visualizer.Commons.Commons.recombine;
import static visualizer.Commons.Commons.saveState;

public class LSDRadixSort {

    public static List<List<Integer>> sort(Integer[] values) {
        List<List<Integer>> sortingStates = new ArrayList<>();
        if (values == null || values.length == 0)
            return sortingStates;

        saveState(values, sortingStates);
        Integer[][] split = Commons.splitPositiveNegative(values);
        Integer[] negative = split[0];
        Integer[] positive = split[1];

        int maxDigits = getMaxDigits(negative, positive);

        for (int exp = 1; maxDigits > 0; exp *= 10, maxDigits--) {
            if (negative.length > 0)
                countSort(negative, exp);
            if (positive.length > 0)
                countSort(positive, exp);
            recombine(values, negative, positive);
            saveState(values, sortingStates);
        }
        return sortingStates;
    }

    private static void countSort(Integer[] arr, int exp) {
        Integer[] output = new Integer[arr.length];
        int[] digitCounts = new int[10];
        Arrays.stream(arr).forEach(value -> digitCounts[(value / exp) % 10]++);
        IntStream.range(1, 10).forEach(i -> digitCounts[i] += digitCounts[i - 1]);
        for (int i = arr.length - 1; i >= 0; i--)
            output[--digitCounts[(arr[i] / exp) % 10]] = arr[i];
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
