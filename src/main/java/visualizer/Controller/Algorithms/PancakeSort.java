package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.List;

import static visualizer.Commons.Commons.toList;

public class PancakeSort {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(toList(values, 0, values.length - 1));
        for(int i = values.length; i > 1; i--) {
            int maxIndex = findMax(values, i);
            if(maxIndex != i - 1) {
                flip(values, maxIndex);
                flip(values, i - 1);
            }
            results.add(toList(values, 0, values.length - 1));
        }
        return results;
    }

    private static void flip(int[] values, int i) {
        for (int start = 0, end = i; start < end; start++, end--) {
            int temp = values[start];
            values[start] = values[end];
            values[end] = temp;
        }
    }

    private static int findMax(int[] values, int n) {
        int mi = 0;
        for(int i = 0; i < n; i++)
            if (values[i] > values[mi])
                mi = i;
        return mi;
    }
}
