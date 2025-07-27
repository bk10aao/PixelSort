package visualizer.Controller.Algorithms;

import java.util.List;

import static visualizer.Commons.Commons.getMaxDigits;
import static visualizer.Commons.Commons.initialize;
import static visualizer.Commons.Commons.recombine;
import static visualizer.Commons.Commons.splitPositiveNegative;
import static visualizer.Commons.Commons.toList;

public class MSDRadixSort {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = initialize(values);
        int[][] split = splitPositiveNegative(values);
        int[] negative = split[0];
        int[] positive = split[1];
        int maxDigits = getMaxDigits(negative, positive);
        if(negative.length > 0)
            msdRadixSort(negative, 0, negative.length, maxDigits - 1, results);
        if(positive.length > 0)
            msdRadixSort(positive, 0, positive.length, maxDigits - 1, results);
        recombine(values, negative, positive);
        results.add(toList(java.util.Arrays.copyOf(values, values.length)));
        return results;
    }

    private static void msdRadixSort(int[] values, int start, int end, int digit, List<List<Integer>> results) {
        if (digit < 0 || start >= end - 1)
            return;
        int[][] buckets = partitionByDigit(values, start, end, digit);
        copyBucketsToArray(values, start, buckets, results);
        int bucketStart = start;
        for (int[] bucket : buckets) {
            if (bucket.length > 1)
                msdRadixSort(values, bucketStart, bucketStart + bucket.length, digit - 1, results);
            bucketStart += bucket.length;
        }
    }

    private static int[][] partitionByDigit(int[] values, int start, int end, int digitPosition) {
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

    private static void copyBucketsToArray(int[] values, int start, int[][] buckets, List<List<Integer>> sortingStates) {
        int index = start;
        for (int[] bucket : buckets) {
            for (int value : bucket) {
                values[index++] = value;
                sortingStates.add(toList(java.util.Arrays.copyOf(values, values.length)));
            }
        }
    }
}