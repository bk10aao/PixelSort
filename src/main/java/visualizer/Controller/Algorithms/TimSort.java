package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.List;

import static visualizer.Commons.Commons.toList;

public class TimSort {

    private static final int MIN_MERGE = 32;

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> sortingStates = new ArrayList<>();
        if (values == null || values.length == 0)
            return sortingStates;

        sortingStates.add(toList(values));
        int minRun = minRunLength(values.length);
        for (int i = 0; i < values.length; i += minRun)
            insertionSort(values, i, Math.min(i + minRun - 1, values.length - 1), sortingStates);

        for (int size = minRun; size < values.length; size *= 2) {
            for (int left = 0; left < values.length; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, values.length - 1);
                if (mid < right && mid < values.length)
                    merge(values, left, mid, right, sortingStates);
            }
        }
        sortingStates.add(toList(values));
        return sortingStates;
    }

    private static int minRunLength(int length) {
        int r = 0;
        while (length >= MIN_MERGE) {
            r |= (length & 1);
            length >>= 1;
        }
        return length + r;
    }

    private static void insertionSort(int[] values, int left, int right, List<List<Integer>> sortingStates) {
        for (int i = left + 1; i <= right; i++) {
            int temp = values[i];
            int j = i - 1;
            while (j >= left && values[j] > temp)
                values[j + 1] = values[j--];
            values[j + 1] = temp;
            sortingStates.add(toList(values));
        }
    }

    private static void merge(int[] values, int left, int mid, int right, List<List<Integer>> sortingStates) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int[] leftArray = new int[len1];
        int[] rightArray = new int[len2];
        System.arraycopy(values, left, leftArray, 0, len1);
        for (int j = 0; j < len2; j++)
            rightArray[j] = values[mid + 1 + j];

        int i = 0;
        int j = 0;
        int k = left;
        while (i < len1 && j < len2) {
            if (leftArray[i] <= rightArray[j])
                values[k++] = leftArray[i++];
            else
                values[k++] = rightArray[j++];
            sortingStates.add(toList(values));
        }

        while (i < len1) {
            values[k++] = leftArray[i++];
            sortingStates.add(toList(values));
        }

        while (j < len2) {
            values[k++] = rightArray[j++];
            sortingStates.add(toList(values));
        }
    }
}