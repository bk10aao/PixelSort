package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static visualizer.Commons.Commons.exchange;
import static visualizer.Commons.Commons.less;

public class ShellSort {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = new ArrayList<>();
        int n = values.length;
        int h = 1;
        results.add(Arrays.stream(values).boxed().toList());
        while (h < n / 3)
            h = 3 * h + 1;
        while (h >= 1) {
            for(int i = h; i < n; i++)
                for (int j = i; j >= h && less(values[j], values[j - h]); j -= h)
                    exchange(values, j, j - h);
            h /= 3;
            results.add(Arrays.stream(values).boxed().toList());
        }
        results.add(Arrays.stream(values).boxed().collect(Collectors.toList()));
        return results;
    }
}
