package visualizer.Controller.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static visualizer.Commons.Commons.exchange;

public class BubbleSort {

    public static List<List<Integer>> sort(int[] numbers) {
        List<List<Integer>> results = new ArrayList<>();
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                results.add(Arrays.stream(numbers).boxed().toList());
                if(numbers[i] > numbers[i + 1]) {
                    exchange(numbers, i, i + 1);
                    swapped = true;
                }
            }
        }
        return results;
    }
}