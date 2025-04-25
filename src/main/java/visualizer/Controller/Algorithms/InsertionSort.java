package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class InsertionSort {

    public static List<List<Integer>> sort(int[] values, List<List<Integer>> results) {
        results.add(Arrays.stream(values).boxed().toList());
        for(int i = 1; i < values.length; i++) {
            int current = values[i];
            int j = i - 1;
            while (j >= 0 && values[j] > current) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = current;
            results.add(Arrays.stream(values).boxed().toList());
        }
        return results;
    }
}
