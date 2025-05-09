package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.List;

import static visualizer.Commons.Commons.getMaxDigits;
import static visualizer.Commons.Commons.recombine;
import static visualizer.Commons.Commons.splitPositiveNegative;
import static visualizer.Commons.Commons.toList;

public class MSDRadixSort {

    public static List<List<Integer>> sort(Integer[] values) {
        List<List<Integer>> sortingStates = new ArrayList<>();
        if(values == null || values.length == 0)
            return sortingStates;
        sortingStates.add(toList(values));
        Integer[][] split = splitPositiveNegative(values);
        Integer[] negative = split[0];
        Integer[] positive = split[1];
        int maxDigits = getMaxDigits(negative, positive);
        if(maxDigits == 0)
            return sortingStates;
        if(negative.length > 0)
            msdRadixSort(negative, 0, negative.length, maxDigits - 1, sortingStates);
        if(positive.length > 0)
            msdRadixSort(positive, 0, positive.length, maxDigits - 1, sortingStates);
        recombine(values, negative, positive);
        sortingStates.add(toList(values));
        return sortingStates;
    }

    private static void msdRadixSort(Integer[] values, int start, int end, int digit, List<List<Integer>> sortingStates) {
        if (digit < 0 || start >= end - 1)
            return;
        int[][] buckets = partitionByDigit(values, start, end, digit);
        copyBucketsToArray(values, start, buckets, sortingStates);
        int bucketStart = start;
        for (int[] bucket : buckets) {
            if (bucket.length > 1)
                msdRadixSort(values, bucketStart, bucketStart + bucket.length, digit - 1, sortingStates);
            bucketStart += bucket.length;
        }
    }

    private static int[][] partitionByDigit(Integer[] values, int start, int end, int digitPosition) {
        int exp = (int) Math.pow(10, digitPosition);
        int[] count = new int[10];
        for (int i = start; i < end; i++)
            count[(values[i] / exp) % 10]++;
        int[][] buckets = new int[10][];
        for (int i = 0; i < 10; i++)
            buckets[i] = new int[count[i]];
        int[] bucketIndices = new int[10];
        for (int i = start; i < end; i++)
            buckets[(values[i] / exp) % 10][bucketIndices[(values[i] / exp) % 10]++] = values[i];
        return buckets;
    }

    private static void copyBucketsToArray(Integer[] values, int start, int[][] buckets, List<List<Integer>> sortingStates) {
        int index = start;
        for (int[] bucket : buckets) {
            for (int value : bucket) {
                values[index++] = value;
                sortingStates.add(toList(values));
            }
        }
    }
}
