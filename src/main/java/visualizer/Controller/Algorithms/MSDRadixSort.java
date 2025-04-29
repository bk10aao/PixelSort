package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.List;

import static visualizer.Commons.Commons.getMaxDigits;
import static visualizer.Commons.Commons.recombine;
import static visualizer.Commons.Commons.saveState;
import static visualizer.Commons.Commons.splitPositiveNegative;

public class MSDRadixSort {

    public static List<List<Integer>> sort(Integer[] arr) {
        List<List<Integer>> sortingStates = new ArrayList<>();
        if(arr == null || arr.length == 0)
            return sortingStates;
        saveState(arr, sortingStates);
        Integer[][] split = splitPositiveNegative(arr);
        Integer[] negative = split[0];
        Integer[] positive = split[1];
        int maxDigits = getMaxDigits(negative, positive);
        if(maxDigits == 0)
            return sortingStates;
        if(negative.length > 0)
            msdRadixSort(negative, 0, negative.length, maxDigits - 1, sortingStates);
        if(positive.length > 0)
            msdRadixSort(positive, 0, positive.length, maxDigits - 1, sortingStates);
        recombine(arr, negative, positive);
        saveState(arr, sortingStates);
        return sortingStates;
    }

    private static void msdRadixSort(Integer[] arr, int start, int end, int digit, List<List<Integer>> sortingStates) {
        if (digit < 0 || start >= end - 1)
            return;
        int[][] buckets = partitionByDigit(arr, start, end, digit);
        copyBucketsToArray(arr, start, buckets);
        saveState(arr, sortingStates);
        int bucketStart = start;
        for (int[] bucket : buckets) {
            int bucketSize = bucket.length;
            if (bucketSize > 1)
                msdRadixSort(arr, bucketStart, bucketStart + bucketSize, digit - 1, sortingStates);
            bucketStart += bucketSize;
        }
    }

    private static int[][] partitionByDigit(Integer[] array, int start, int end, int digitPosition) {
        int exp = (int) Math.pow(10, digitPosition);
        int[] count = new int[10];
        for (int i = start; i < end; i++)
            count[(array[i] / exp) % 10]++;
        int[][] buckets = new int[10][];
        for (int i = 0; i < 10; i++)
            buckets[i] = new int[count[i]];
        int[] bucketIndices = new int[10];
        for (int i = start; i < end; i++)
            buckets[(array[i] / exp) % 10][bucketIndices[(array[i] / exp) % 10]++] = array[i];

        return buckets;
    }

    private static void copyBucketsToArray(Integer[] array, int start, int[][] buckets) {
        int index = start;
        for (int[] bucket : buckets)
            for (int value : bucket)
                array[index++] = value;
    }
}
