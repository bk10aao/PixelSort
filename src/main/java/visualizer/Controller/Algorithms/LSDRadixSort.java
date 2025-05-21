package visualizer.Controller.Algorithms;

import java.util.Arrays;
import java.util.List;

import static visualizer.Commons.Commons.getMaxDigits;
import static visualizer.Commons.Commons.initialize;
import static visualizer.Commons.Commons.recombine;
import static visualizer.Commons.Commons.splitPositiveNegative;
import static visualizer.Commons.Commons.toList;

public class LSDRadixSort {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = initialize(values);
        if(values.length == 1)
            return results;
        int[][] split = splitPositiveNegative(values);
        int[] negative = split[0];
        int[] positive = split[1];

        int maxDigits = getMaxDigits(negative, positive);

        for (int exp = 1; maxDigits > 0; exp *= 10, maxDigits--) {
            if (negative.length > 0)
                countSort(negative, exp, results);
            if (positive.length > 0)
                countSort(positive, exp, results);
            recombine(values, negative, positive);
            results.add(toList(values));
        }
        return results;
    }

    private static void countSort(int[] values, int exp, List<List<Integer>> sortingStates) {
        int[] digitCounts = new int[10];

        for (int value : values)
            digitCounts[(value / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            digitCounts[i] += digitCounts[i - 1];

        int[] output = new int[values.length];
        int[] currentState = Arrays.copyOf(values, values.length);

        for (int i = values.length - 1; i >= 0; i--) {
            int digit = (values[i] / exp) % 10;
            int index = --digitCounts[digit];
            output[index] = values[i];
            currentState[index] = values[i];
            sortingStates.add(toList(Arrays.copyOf(currentState, currentState.length)));
        }

        System.arraycopy(output, 0, values, 0, values.length);
        sortingStates.add(toList(values));
    }
}
