package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static visualizer.Commons.Commons.exchange;

public class BubbleSort {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = new ArrayList<>();
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < values.length - 1; i++) {
                if(values[i] > values[i + 1]) {
                    exchange(values, i, i + 1, results);
                    swapped = true;
                    results.add(Arrays.stream(values).boxed().toList());
                }
            }
        }
        return results;
    }
}