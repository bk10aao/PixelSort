package visualizer.Controller.Algorithms;

import visualizer.Commons.Commons;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TimSort {

    private static final int MIN_MERGE = 32;
    static List<List<Integer>> results = new ArrayList<>();

    public static List<List<Integer>> sort(int[] arr) {

        results.add(Commons.toList(arr));
        int minRun = minRunLength(MIN_MERGE);
        for (int i = 0; i < arr.length; i += minRun)
            insertionSort(arr, i, Math.min((i + MIN_MERGE - 1), (arr.length - 1)));
        for (int size = minRun; size < arr.length; size = 2 * size) {
            for (int left = 0; left < arr.length; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (arr.length - 1));
                if (mid < right)
                    merge(arr, left, mid, right);
            }
        }
        results.add(Commons.toList(arr));
        return results;
    }

    public static int minRunLength(int n) {
        assert n >= 0;
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp)
                arr[j + 1] = arr[j--];
            arr[j + 1] = temp;
            results.add(Commons.toList(arr));
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int len1 = m - l + 1;
        int len2 = r - m;
        int[] right = IntStream.range(0, len2).map(x -> arr[m + 1 + x]).toArray();
        int i = 0;
        int j = 0;
        int k = l;
        while (i < len1 && j < len2)
            if (arr[i] <= right[j])
                arr[k] = arr[i++];
            else
                arr[k++] = right[j++];
        while (i < len1)
            arr[k++] = arr[i++];
        while (j < len2)
            arr[k++] = right[j++];
    }
}
