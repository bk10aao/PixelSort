package visualizer.Controller.Algorithms;

import visualizer.Commons.Commons;

import java.util.Arrays;
import java.util.List;

public class QuickSort {

    public static void sort(int[] values, List<List<Integer>> results) {
        Commons.shuffle(values);
        sort(values, 0, values.length - 1, results);
    }

    private static void sort(int[] values, int low, int high, List<List<Integer>> results) {
        if(high <= low)
            return;
        results.add(Arrays.stream(values).boxed().toList());
        int j = partition(values, low, high);
        sort(values, low, j - 1, results);
        sort(values, j + 1, high, results);
    }

    private static int partition(int[] values, int low, int high) {
        int leftPointer = low;
        int rightPointer = high + 1;
        while (true) {
            while(Commons.less(values[++leftPointer], values[low]))
                if (leftPointer == high)
                    break;
            while(Commons.less(values[low], values[--rightPointer]))
                if (rightPointer == low)
                    break;
            if(leftPointer >= rightPointer)
                break;
            Commons.exchange(values, leftPointer, rightPointer);
        }
        Commons.exchange(values, low, rightPointer);
        return rightPointer;
    }
}