package visualizer.Controller.Algorithms;

import java.util.List;

import static visualizer.Commons.Commons.exchange;
import static visualizer.Commons.Commons.initialize;
import static visualizer.Commons.Commons.toList;

public class BubbleSort {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = initialize(values);
        if (values.length == 1)
            return results;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < values.length - 1; i++)
                if (values[i] > values[i + 1]) {
                    exchange(values, i, i + 1);
                    swapped = true;
                    results.add(toList(values));
                }
        }
        return results;
    }
}