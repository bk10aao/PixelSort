package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimSortTest {
    @Test
    public void timSort_triggersRunStackMergeLogicWithLargeInput() {
        int[] input = new int[40];
        for (int i = 0; i < 10; i++)
            input[i] = i + 1;
        for (int i = 10; i < 20; i++)
            input[i] = 30 - i;
        for (int i = 20; i < 40; i++)
            input[i] = i + 1;
        int[] sorted = input.clone();
        Arrays.sort(sorted);
        assertEquals(List.of(java.util.Arrays.stream(sorted).boxed().toArray(Integer[]::new)), TimSort.sort(input).getLast());
    }
}
