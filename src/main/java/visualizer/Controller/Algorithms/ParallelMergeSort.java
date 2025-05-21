package visualizer.Controller.Algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import static java.util.concurrent.ForkJoinPool.commonPool;
import static visualizer.Commons.Commons.initialize;
import static visualizer.Commons.Commons.toList;

public class ParallelMergeSort {

    private static final int THRESHOLD = 10;

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = initialize(values);
        if(values.length == 1)
            return results;
        ForkJoinPool forkJoinPool = commonPool();
        forkJoinPool.invoke(new MergeSortTask(values, 0, values.length - 1, results));
        results.add(toList(values));
        return results;
    }

    static class MergeSortTask extends RecursiveAction {
        private final int[] array;
        private final int left;
        private final int right;
        private final List<List<Integer>> results;

        public MergeSortTask(int[] array, int left, int right, List<List<Integer>> results) {
            this.array = array;
            this.left = left;
            this.right = right;
            this.results = results;
        }

        @Override
        protected void compute() {
            if (right - left <= THRESHOLD)
                sequentialMergeSort(array, left, right, results);
            else {
                int mid = left + (right - left) / 2;
                MergeSortTask leftTask = new MergeSortTask(array, left, mid, results);
                MergeSortTask rightTask = new MergeSortTask(array, mid + 1, right, results);
                invokeAll(leftTask, rightTask);
                merge(array, left, mid, right, results);
            }
        }
    }

    private static void sequentialMergeSort(int[] values, int left, int right, List<List<Integer>> results) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sequentialMergeSort(values, left, mid, results);
            sequentialMergeSort(values, mid + 1, right, results);
            merge(values, left, mid, right, results);
        }
    }

    private static void merge(int[] values, int left, int mid, int right, List<List<Integer>> states) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int[] leftArray = new int[len1];
        int[] rightArray = new int[len2];

        Arrays.setAll(leftArray, i -> values[left + i]);
        Arrays.setAll(rightArray, i -> values[mid + 1 + i]);

        int i = 0;
        int j = 0;
        int k = left;
        while (i < len1 && j < len2) {
            if (leftArray[i] <= rightArray[j])
                values[k++] = leftArray[i++];
            else
                values[k++] = rightArray[j++];
            states.add(toList(values));
        }
        while (i < len1) {
            values[k++] = leftArray[i++];
            states.add(toList(values));
        }
        while (j < len2) {
            values[k++] = rightArray[j++];
            states.add(toList(values));
        }
    }
}
