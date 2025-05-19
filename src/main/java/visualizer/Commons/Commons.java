package visualizer.Commons;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Commons {

    public static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    public static List<Integer> toList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static void recombine(int[] arr, int[] negative, int[] positive) {
        for(int i = negative.length - 1, j = 0; i >= 0; i--)
            arr[j++] = -negative[i];
        System.arraycopy(positive, 0, arr, negative.length, positive.length);
    }

    public static int getMaxDigits(int[] negative, int[] positive) {
        int maxNegative = 0;
        int maxPositive = 0;
        for(int i : positive)
            if (less(maxNegative, i))
                maxNegative = i;
        for(int i : negative)
            if (less(maxPositive, i))
                maxPositive = i;

        return maxNegative == 0 && maxPositive == 0 ? 0 : String.valueOf(Math.max(maxNegative, maxPositive)).length();
    }

    public static int[][] splitPositiveNegative(int[] array) {
        Map<Boolean, List<Integer>> split = Arrays.stream(array)
                .boxed()
                .collect(Collectors.partitioningBy(i -> i < 0));

        int[] negatives = split.get(true).stream()
                .mapToInt(Math::abs)
                .toArray();

        int[] positives = split.get(false).stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return new int[][]{negatives, positives};
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