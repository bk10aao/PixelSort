package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionSortTest {

    @Test
    public void givenReversedArray_onSort_triggersInsertionShift() {
        assertEquals(List.of(1, 2, 3, 4, 5), InsertionSort.sort(new int[] {5, 4, 3, 2, 1}).getLast());
    }

    @Test
    public void givenTwoElementReversedArray_onSort_triggersShiftOnce() {
        assertEquals(List.of(1, 2), InsertionSort.sort(new int[] {2, 1}).getLast());
    }
}