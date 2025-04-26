package visualizer.Controller.Algorithms;

import visualizer.Commons.Commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            int min = i;
            for (int j = i + 1; j < values.length; j++)
                if (values[j] < values[min])
                    min = j;
            Commons.exchange(values, i, min);
            results.add(Arrays.stream(values).boxed().toList());
        }
        return results;
    }
}