package visualizer.Controller.Algorithms;

import java.util.List;

import static visualizer.Commons.Commons.initialize;
import static visualizer.Commons.Commons.toList;

public class InPlaceMergeSort {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = initialize(values);
        mergeSort(values, 0, values.length - 1, results);
        results.add(toList(values));
        return results;
    }

    private static void inPlaceMerge(int[] values, int start, int mid, int end, List<List<Integer>> result) {
        int right = mid + 1;
        while (start <= mid && right <= end) {
            if (values[start] <= values[right])
                start++;
            else {
                int value = values[right];
                int index = right++;
                while (index != start) {
                    values[index] = values[index - 1];
                    index--;
                }
                values[start++] = value;
                mid++;
                result.add(toList(values));
            }
        }
    }

    private static void mergeSort(int[] nums, int s, int e, List<List<Integer>> result) {
        if(s == e)
            return;
        int mid = s + (e - s) / 2;
        mergeSort(nums, s, mid, result);
        mergeSort(nums, mid + 1, e, result);
        inPlaceMerge(nums, s, mid, e, result);
    }
}
