package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.List;

import static visualizer.Commons.Commons.exchange;
import static visualizer.Commons.Commons.toList;

public class SelectionSort {

    public static List<List<Integer>> sort(int[] values) {
        if (values == null)
            throw new NullPointerException();
        if (values.length == 0)
            throw new IllegalArgumentException();
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            int min = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] < values[min]) {
                    min = j;
                }
            }
            if (i != min) {
                exchange(values, i, min);
                results.add(toList(values));
            }
        }
        if (results.isEmpty()) {
            results.add(toList(values));
        }
        return results;
    }
}