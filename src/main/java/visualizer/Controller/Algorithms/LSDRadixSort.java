package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import visualizer.Commons.Commons;

public class LSDRadixSort {
    private final List<List<Integer>> sortingStates = new ArrayList<>();

    public List<List<Integer>> sort(Integer[] arr) {
        if (arr == null || arr.length == 0)
            return sortingStates;

        saveState(arr);
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
            saveState(arr);
        }

        return sortingStates;
    }

    private void countSort(Integer[] arr, int exp) {
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


    private void saveState(Integer[] arr) {
        sortingStates.add(Commons.toList(arr));
    }

    private int getMaxDigits(Integer[] positive, Integer[] negative) {
        int maxNeg = 0, maxPos = 0;
        for (Integer value : positive)
            if (Commons.less(maxNeg, value))
                maxNeg = value;
        for (int value : negative)
            if (Commons.less(maxPos, value))
                maxPos = value;
        return maxNeg == 0 && maxPos == 0 ? 0 : String.valueOf(Math.max(maxNeg, maxPos)).length();
    }

    private void recombine(Integer[] arr, Integer[] negative, Integer[] positive) {
        for (int i = negative.length - 1, j = 0; i >= 0; i--)
            arr[j++] = -negative[i];
        System.arraycopy(positive, 0, arr, negative.length, positive.length);
    }

    public static void main(String[] args) {
        Integer[] arr = { 1012, 5221, 2212, 3234, -3417, -1532, -1020, -1012, -5221, -2212, -3234, 3417, 1532, 1020 };
        System.out.println("Initial array: " + Arrays.toString(arr));
        LSDRadixSort sorter = new LSDRadixSort();
        List<List<Integer>> states = sorter.sort(arr);
        System.out.println("Final sorted array: " + Arrays.toString(arr));
        System.out.println("Intermediate states:");
        for (int i = 0; i < states.size(); i++) {
            System.out.printf("State %d: %s%n", i, states.get(i));
        }
    }
}
