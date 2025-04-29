package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.List;

import static visualizer.Commons.Commons.toList;

public class TimSort {

    private static final int MIN_MERGE = 32;

    public static List<List<Integer>> sort(int[] array) {
        List<List<Integer>> sortingStates = new ArrayList<>();
        if (array == null || array.length == 0)
            return sortingStates;

        sortingStates.add(toList(array));
        int minRun = minRunLength(array.length);
        for (int i = 0; i < array.length; i += minRun)
            insertionSort(array, i, Math.min(i + minRun - 1, array.length - 1), sortingStates);

        for (int size = minRun; size < array.length; size *= 2) {
            for (int left = 0; left < array.length; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, array.length - 1);
                if (mid < right && mid < array.length)
                    merge(array, left, mid, right, sortingStates);
            }
        }
        sortingStates.add(toList(array));
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

    private static void insertionSort(int[] array, int left, int right, List<List<Integer>> sortingStates) {
        for (int i = left + 1; i <= right; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= left && array[j] > temp)
                array[j + 1] = array[j--];
            array[j + 1] = temp;
            sortingStates.add(toList(array));
        }
    }

    private static void merge(int[] array, int left, int mid, int right, List<List<Integer>> sortingStates) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int[] leftArray = new int[len1];
        int[] rightArray = new int[len2];
        for (int i = 0; i < len1; i++)
            leftArray[i] = array[left + i];
        for (int j = 0; j < len2; j++)
            rightArray[j] = array[mid + 1 + j];

        int i = 0;
        int j = 0;
        int k = left;
        while (i < len1 && j < len2) {
            if (leftArray[i] <= rightArray[j])
                array[k++] = leftArray[i++];
            else
                array[k++] = rightArray[j++];
            sortingStates.add(toList(array));
        }

        while (i < len1) {
            array[k++] = leftArray[i++];
            sortingStates.add(toList(array));
        }

        while (j < len2) {
            array[k++] = rightArray[j++];
            sortingStates.add(toList(array));
        }
    }
}