package visualizer.Controller.Algorithms;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static visualizer.Commons.Commons.exchange;

public class SelectionSort {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            int min = i;
            for (int j = i + 1; j < values.length; j++)
                if (values[j] < values[min])
                    min = j;
            if (i != min) {
                exchange(values, i, min, results);
                results.add(Arrays.stream(values).boxed().toList());
            }
        }
        results.add(Arrays.stream(values).boxed().toList());
        return results;
    }
}