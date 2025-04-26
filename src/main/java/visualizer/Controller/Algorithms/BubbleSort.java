package visualizer.Controller.Algorithms;

import visualizer.Commons.Commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static List<List<Integer>> sort (int[] numbers) {
        List<List<Integer>> results = new ArrayList<>();
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                results.add(Arrays.stream(numbers).boxed().toList());
                if(numbers[i] > numbers[i + 1]) {
                    Commons.exchange(numbers, i, i + 1);
                    swapped = true;
                }
            }
        }
        return results;
    }
}