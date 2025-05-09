package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static visualizer.Commons.Commons.exchange;
import static visualizer.Commons.Commons.less;

public class ShellSort {

    public static List<List<Integer>> sort(int[] values) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(Arrays.stream(values).boxed().toList());
        List<Integer> increments = generateIncrements(values.length);
        for(int x = increments.size() - 1; x >= 0; x--)
            hSort(values, increments.get(x), results);
        return results;
    }

    private static void hSort(int[] values, int h, List<List<Integer>> results) {
        for(int x = h; x < values.length; x++)
            for(int y = x; y >= h && less(values[y], values[y - h]); y -= h) {
                exchange(values, y, y - h, results);
                results.add(Arrays.stream(values).boxed().toList());
            }
    }

    private static List<Integer> generateIncrements(int n) {
        List<Integer> increments = new ArrayList<>();
        int x = 0;
        while (true) {
            int y;
            if (x % 2 == 0)
                y = (int) (9 * (1L << x) - 9 * (1L << (x / 2)) + 1);
            else
                y = (int) (8 * (1L << x) - 6 * (1L << ((x + 1) / 2)) + 1);
            if (y >= n)
                break;
            increments.add(y);
            x++;
        }
        if (!increments.contains(1)) {
            increments.add(1);
            increments.sort(Integer::compareTo);
        }
        return increments;
    }
}
