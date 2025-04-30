package visualizer.Controller.Algorithms;

import visualizer.Commons.Commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import static java.util.concurrent.ForkJoinPool.commonPool;
import static visualizer.Commons.Commons.toList;

public class ParallelMergeSort {

    private static final int THRESHOLD = 1000;

    public static List<List<Integer>> sort(int[] array) {
        List<List<Integer>> states = new ArrayList<>();
        if(array.length == 0)
            return states;
        states.add(toList(array));
        ForkJoinPool forkJoinPool = commonPool();
        forkJoinPool.invoke(new MergeSortTask(array, 0, array.length - 1, states));
        states.add(toList(array));
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
            if(right - left <= THRESHOLD)
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

    private static void sequentialMergeSort(int[] array, int left, int right, List<List<Integer>> states) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            sequentialMergeSort(array, left, mid, states);
            sequentialMergeSort(array, mid + 1, right, states);
            merge(array, left, mid, right, states);
        }
    }

    private static void merge(int[] array, int left, int mid, int right, List<List<Integer>> states) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int[] leftArray = new int[len1];
        int[] rightArray = new int[len2];

        Arrays.setAll(leftArray, i -> array[left + i]);
        Arrays.setAll(rightArray, i -> array[mid + 1 + i]);

        int i = 0;
        int j = 0;
        int k = left;
        while(i < len1 && j < len2) {
            if (leftArray[i] <= rightArray[j])
                array[k++] = leftArray[i++];
            else
                array[k++] = rightArray[j++];
            states.add(toList(array));
        }
        while (i < len1) {
            array[k++] = leftArray[i++];
            states.add(toList(array));
        }
        while (j < len2) {
            array[k++] = rightArray[j++];
            states.add(toList(array));
        }
    }

}
