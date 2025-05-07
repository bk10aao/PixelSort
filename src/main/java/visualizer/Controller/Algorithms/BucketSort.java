package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static visualizer.Commons.Commons.toList;

public class BucketSort {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = new ArrayList<>();
        if (values == null || values.length == 0)
            return results;

        results.add(toList(values));
        int min = values[0];
        int max = values[0];
        for (int value : values) {
            if (value < min)
                min = value;
            else if (value > max)
                max = value;
        }

        int bucketSize = Math.min(10, values.length);
        double range = Math.ceil((double)(max - min + 1) / bucketSize);
        List<Integer>[] buckets = new LinkedList[bucketSize];
        Arrays.setAll(buckets, i -> new LinkedList<>());
        for (int value : values) {
            int bucketIndex = (int)((value - min) / range);
            bucketIndex = Math.min(bucketIndex, bucketSize - 1);
            buckets[bucketIndex].add(value);
        }
        int[] distributedValues = values.clone();
        int index = 0;
        for (int i = 0; i < bucketSize; i++)
            for (int value : buckets[i])
                distributedValues[index++] = value;
        System.arraycopy(distributedValues, 0, values, 0, values.length);
        results.add(toList(values));
        index = 0;
        for (int i = 0; i < bucketSize; i++) {
            if (!buckets[i].isEmpty()) {
                int bucketStartIndex = index;
                int[] bucketArray = buckets[i].stream().mapToInt(Integer::intValue).toArray();
                insertionSort(values, bucketStartIndex, bucketArray.length, results);
                index += bucketArray.length;
                buckets[i].clear();
                buckets[i].addAll(Arrays.stream(values, bucketStartIndex, bucketStartIndex + bucketArray.length)
                        .boxed()
                        .toList());
                results.add(toList(values));
            }
        }
        results.add(toList(values));
        return results;
    }

    private static void insertionSort(int[] values, int bucketStartIndex, int bucketLength, List<List<Integer>> sortingStates) {
        int right = bucketStartIndex + bucketLength - 1;
        for (int i = bucketStartIndex + 1; i <= right; i++) {
            int temp = values[i];
            int j = i - 1;
            while (j >= bucketStartIndex && values[j] > temp) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = temp;
            sortingStates.add(toList(values));
        }
    }
}