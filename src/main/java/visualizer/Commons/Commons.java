package visualizer.Commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Commons {

    public static void exchange(int[] values, int i, int j) {
        int swap = values[i];
        values[i] = values[j];
        values[j] = swap;
    }

    public static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    public static void shuffle(int[] values) {
        Random rand = new Random();
        for (int i = values.length - 1; i > 0; i--)
            Commons.exchange(values, i, rand.nextInt(i + 1));
    }

    public static void merge(int[] values1, int[] values2, int low, int middle, int high) {
        isSorted(values1, low, middle, high);
        if (high + 1 - low >= 0) System.arraycopy(values2, low, values1, low, high + 1 - low);
        int i = low;
        int j = middle + 1;
        for (int x = low; x <= high; x++)
            if (i > middle)
                values2[x] = values1[j++];
            else if (j > high)
                values2[x] = values1[i++];
            else if (less(values1[j], values1[i]))
                values2[x] = values1[j++];
            else
                values2[x] = values1[i++];
    }

    public static void isSorted(int[] values1, int low, int middle, int high) {
        assert Commons.isSorted(values1, low, middle);
        assert Commons.isSorted(values1, middle + 1, high);
    }

    public static boolean isSorted(int[] values, int low, int high) {
        for (int i = low + 1; i <= high; i++)
            if (less(values[i], values[i - 1]))
                return false;
        return true;
    }

    public static void sink(int[] binaryHeap, int index, int n) {
        while (2 * index <= n) {
            int j = 2 * index;
            if (j < n && Commons.less(binaryHeap[j], binaryHeap[j + 1]))
                j++;
            if (!Commons.less(binaryHeap[index], binaryHeap[j]))
                break;
            Commons.exchange(binaryHeap, index, j);
            index = j;
        }
    }

    public static List<Integer> toList(int[] arr, int from, int to) {
        return IntStream.rangeClosed(from, to).mapToObj(i -> arr[i]).collect(Collectors.toList());
    }

    public static List<Integer> toList(Integer[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static List<Integer> toList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static void saveState(Integer[] arr, List<List<Integer>> sortingStates) {
        sortingStates.add(Commons.toList(arr));
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
}