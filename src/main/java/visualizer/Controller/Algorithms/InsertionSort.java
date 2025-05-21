package visualizer.Controller.Algorithms;

import java.util.Arrays;
import java.util.List;

import static visualizer.Commons.Commons.exchange;
import static visualizer.Commons.Commons.initialize;
import static visualizer.Commons.Commons.toList;

public class InsertionSort {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = initialize(values);
        for(int i = 1; i < values.length; i++) {
            int current = values[i];
            int j = i - 1;
            while (j >= 0 && values[j] > current) {
                exchange(values, j + 1, j--);
                results.add(toList(values));
            }
            values[j + 1] = current;
            results.add(Arrays.stream(values).boxed().toList());
        }
        return results;
    }
}
