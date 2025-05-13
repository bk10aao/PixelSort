package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import static java.util.concurrent.ForkJoinPool.commonPool;
import static visualizer.Commons.Commons.toList;

public class ParallelMergeSort {

    private static final int THRESHOLD = 1000;

    public static List<List<Integer>> sort(int[] values) {
        if(values == null)
            throw new NullPointerException();
        if(values.length == 0)
            throw new IllegalArgumentException();
        List<List<Integer>> states = new ArrayList<>();
        states.add(toList(values));
        ForkJoinPool forkJoinPool = commonPool();
        forkJoinPool.invoke(new MergeSortTask(values, 0, values.length - 1, states));
        states.add(toList(values));
        return states;
    }

    static class MergeSortTask extends RecursiveAction {
        private final int[] array;
        private final int left;
        private final int right;
        private final List<List<Integer>> states;

        public MergeSortTask(int[] array, int left, int right, List<List<Integer>> states) {
            this.array = array;
            this.left = left;
            this.right = right;
            this.states = states;
        }

        @Override
        protected void compute() {
            if (right - left <= THRESHOLD)
                sequentialMergeSort(array, left, right, states);
            else {
                int mid = left + (right - left) / 2;
                MergeSortTask leftTask = new MergeSortTask(array, left, mid, states);
                MergeSortTask rightTask = new MergeSortTask(array, mid + 1, right, states);
                invokeAll(leftTask, rightTask);
                merge(array, left, mid, right, states);
            }
        }
    }

    private static void sequentialMergeSort(int[] values, int left, int right, List<List<Integer>> states) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sequentialMergeSort(values, left, mid, states);
            sequentialMergeSort(values, mid + 1, right, states);
            merge(values, left, mid, right, states);
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
