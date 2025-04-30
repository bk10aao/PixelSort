package visualizer.Controller.Algorithms;

import visualizer.Commons.Commons;

import java.util.ArrayList;
import java.util.List;

public class InPlaceMergeSort {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Commons.toList(values));
        mergeSort(values, 0, values.length - 1, result);
        result.add(Commons.toList(values));
        return result;
    }

    private static int nextGap(int gap) {
        return gap <= 1 ? 0 : (int)Math.ceil(gap / 2.0);
    }

    private static void inPlaceMerge(int[] nums, int start, int end, List<List<Integer>> result) {
        int gap = end - start + 1;
        for(gap = nextGap(gap); gap > 0; gap = nextGap(gap))
            for (int i = start; i + gap <= end; i++)
                if (nums[i] > nums[i + gap])
                    Commons.exchange(nums, i, i + gap);
        result.add(Commons.toList(nums));
    }

    private static void mergeSort(int[] nums, int s, int e, List<List<Integer>> result) {
        if(s == e)
            return;
        int mid = (s + e) / 2;
        mergeSort(nums, s, mid, result);
        mergeSort(nums, mid + 1, e, result);
        inPlaceMerge(nums, s, e, result);
    }
}
