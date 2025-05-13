package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static visualizer.Commons.Commons.toList;

public class InsertionSort {

    public static List<List<Integer>> sort(int[] values) {
        if (values == null)
            throw new NullPointerException();
        if (values.length == 0)
            throw new IllegalArgumentException();
        List<List<Integer>> results = new ArrayList<>();
        results.add(toList(values));
        for(int i = 1; i < values.length; i++) {
            int current = values[i];
            int j = i - 1;
            while (j >= 0 && values[j] > current) {
                values[j + 1] = values[j--];
                results.add(toList(values));
            }
            values[j + 1] = current;
            results.add(Arrays.stream(values).boxed().toList());
        }
        return results;
    }
}
