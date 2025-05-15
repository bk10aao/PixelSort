package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectionSortTest {

    @Test
    public void givenUnsortedArray_onSort_triggersExchangeAndMinChange() {
        assertEquals(List.of(1, 2, 3, 4, 5), SelectionSort.sort(new int[]{5, 3, 4, 1, 2}).getLast());
    }

    @Test
    public void givenTwoElementUnsortedArray_onSort_triggersSwap() {
        assertEquals(List.of(1, 2), SelectionSort.sort(new int[]{2, 1}).getLast());
    }
}