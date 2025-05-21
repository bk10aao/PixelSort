package visualizer.Controller.Algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static visualizer.Commons.Commons.initialize;
import static visualizer.Commons.Commons.insertionSort;
import static visualizer.Commons.Commons.toList;


public class BucketSort {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = initialize(values);
        if (values.length == 1)
            return results;

        MinMax minMax = findMinMax(values);
        if (minMax.min == minMax.max)
            return results;
        int numBuckets = Math.min(10, values.length);
        double bucketRange = Math.ceil((double) (minMax.max - minMax.min + 1) / numBuckets);
        List<Integer>[] buckets = new List[numBuckets];
        Arrays.setAll(buckets, i -> new LinkedList<>());
        distributeToBuckets(values, minMax.min, bucketRange, buckets);
        sortAndMergeBuckets(values, buckets, results);
        return results;
    }

    private static MinMax findMinMax(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int value : array) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        return new MinMax(min, max);
    }

    private static void distributeToBuckets(int[] array, int min, double bucketRange, List<Integer>[] buckets) {
        for (int value : array) {
            int bucketIndex = (int) ((value - min) / bucketRange);
            bucketIndex = Math.min(bucketIndex, buckets.length - 1);
            buckets[bucketIndex].add(value);
        }
    }

    private static void sortAndMergeBuckets(int[] array, List<Integer>[] buckets, List<List<Integer>> results) {
        int index = 0;
        for (List<Integer> bucket : buckets) {
            if (!bucket.isEmpty()) {
                int startIndex = index;
                int[] bucketArray = bucket.stream().mapToInt(Integer::intValue).toArray();
                System.arraycopy(bucketArray, 0, array, startIndex, bucketArray.length);
                insertionSort(array, startIndex, startIndex + bucketArray.length - 1, results);
                index += bucketArray.length;
                results.add(toList(array));
            }
        }
    }

    private record MinMax(int min, int max) { }
}