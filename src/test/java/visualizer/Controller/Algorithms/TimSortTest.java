package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static visualizer.Controller.Algorithms.Commons.expectedResultFive;
import static visualizer.Controller.Algorithms.Commons.expectedResultFour;
import static visualizer.Controller.Algorithms.Commons.expectedResultOne;
import static visualizer.Controller.Algorithms.Commons.expectedResultSeven;
import static visualizer.Controller.Algorithms.Commons.expectedResultSix;
import static visualizer.Controller.Algorithms.Commons.expectedResultThree;
import static visualizer.Controller.Algorithms.Commons.expectedResultTwo;
import static visualizer.Controller.Algorithms.Commons.testArrayFive;
import static visualizer.Controller.Algorithms.Commons.testArrayFour;
import static visualizer.Controller.Algorithms.Commons.testArrayOne;
import static visualizer.Controller.Algorithms.Commons.testArraySeven;
import static visualizer.Controller.Algorithms.Commons.testArraySix;
import static visualizer.Controller.Algorithms.Commons.testArrayThree;
import static visualizer.Controller.Algorithms.Commons.testArrayTwo;

class TimSortTest {

    @Test
    public void givenAnEmptyArray_onSort_returnsEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> TimSort.sort(new int[]{}));
    }

    @Test
    public void givenNullArray_onSort_returnsEmptyList() {
        assertThrows(NullPointerException.class, ()-> TimSort.sort(null));
    }

    @Test
    public void givenTestArrayOne_onSort_returnsSortedListOne() {
        assertEquals(expectedResultOne, TimSort.sort(testArrayOne).getLast());
    }

    @Test
    public void givenTestArrayTwo_onSort_returnsSortedListTwo() {
        assertEquals(expectedResultTwo, TimSort.sort(testArrayTwo).getLast());
    }

    @Test
    public void givenTestArrayThree_onSort_returnsSortedListThree() {
        assertEquals(expectedResultThree, TimSort.sort(testArrayThree).getLast());
    }

    @Test
    public void givenTestArrayFour_onSort_returnsSortedListFour() {
        assertEquals(expectedResultFour, TimSort.sort(testArrayFour).getLast());
    }

    @Test
    public void givenTestArrayOf200Items_onSort_returnsSortedListFour() {
        assertEquals(expectedResultFive, TimSort.sort(testArrayFive).getLast());
    }

    @Test
    public void givenTestArrayOf500Items_onSort_returnsSortedListFour() {
        assertEquals(expectedResultSix, TimSort.sort(testArraySix).getLast());
    }

    @Test
    public void givenTestArrayOf1000Items_onSort_returnsSortedListFour() {
        assertEquals(expectedResultSeven, TimSort.sort(testArraySeven).getLast());
    }

    @Test
    public void givenTestArrayFive_onSort_returnsSortedListFive() {
        assertEquals(expectedResultFive, TimSort.sort(testArrayFive).getLast());
    }

    @Test
    public void givenTestArraySix_onSort_returnsSortedListSix() {
        assertEquals(expectedResultSix, TimSort.sort(testArraySix).getLast());
    }

    @Test
    public void givenTestArraySeven_onSort_returnsSortedListSeven() {
        assertEquals(expectedResultSeven, TimSort.sort(testArraySeven).getLast());
    }

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