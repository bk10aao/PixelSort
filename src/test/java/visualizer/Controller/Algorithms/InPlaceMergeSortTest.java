package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InPlaceMergeSortTest {

    @Test
    public void givenReversedTwoElementArray_triggersInPlaceMergeShift() {
        assertEquals(List.of(1, 2), InPlaceMergeSort.sort(new int[] {2, 1}).getLast());
    }

    @Test
    public void givenPartialSortedArray_triggersMultipleInPlaceShifts() {
        assertEquals(List.of(1, 2, 4, 5), InPlaceMergeSort.sort(new int[] {4, 5, 1, 2}).getLast());
    }
}