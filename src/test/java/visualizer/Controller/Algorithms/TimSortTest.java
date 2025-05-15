package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimSortTest {

    @Test
    public void triggersRunStackMergeLogicWithLargeInput() {
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

    @Test
    public void triggersMergeInRunStackWithEnoughLength() {
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), TimSort.sort(new int[] { 1, 2, 3, 4, 5, 10, 9, 8, 7, 6, 11, 12, 13, 14, 15}).getLast());
    }

    @Test
    public void triggersLeftArrayDrainInMerge() {
        assertEquals(List.of(1, 2, 3, 4, 5, 7), TimSort.sort(new int[] {1, 3, 5, 7, 2, 4}).getLast());
    }
}