package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static visualizer.Commons.Commons.getMaxDigits;
import static visualizer.Commons.Commons.recombine;
import static visualizer.Commons.Commons.splitPositiveNegative;
import static visualizer.Commons.Commons.toList;

public class LSDRadixSort {

    public static List<List<Integer>> sort(Integer[] values) {
        List<List<Integer>> sortingStates = new ArrayList<>();
        if (values == null || values.length == 0)
            return sortingStates;
        sortingStates.add(toList(values));
        Integer[][] split = splitPositiveNegative(values);
        Integer[] negative = split[0];
        Integer[] positive = split[1];

        int maxDigits = getMaxDigits(negative, positive);

        for (int exp = 1; maxDigits > 0; exp *= 10, maxDigits--) {
            if (negative.length > 0)
                countSort(negative, exp, sortingStates);
            if (positive.length > 0)
                countSort(positive, exp, sortingStates);
            recombine(values, negative, positive);
            sortingStates.add(toList(values));
        }
        return sortingStates;
    }

    private static void countSort(Integer[] values, int exp, List<List<Integer>> sortingStates) {
        Integer[] output = new Integer[values.length];
        int[] digitCounts = new int[10];

        for (int value : values)
            digitCounts[(value / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            digitCounts[i] += digitCounts[i - 1];

        for (int i = values.length - 1; i >= 0; i--) {
            int index = --digitCounts[(values[i] / exp) % 10];
            output[index] = values[i];
            Integer[] visual = Arrays.copyOf(values, values.length);
            for (int j = 0; j < output.length; j++)
                if (output[j] != null)
                    visual[j] = output[j];
            sortingStates.add(toList(values));
        }
        System.arraycopy(output, 0, values, 0, values.length);
        sortingStates.add(toList(values));
    }
}
