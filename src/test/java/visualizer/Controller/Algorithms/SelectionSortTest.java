package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectionSortTest {

    @Test
    public void selectionSort_givenTwoElementUnsortedArray_onSort_triggersSwap() {
        assertEquals(List.of(1, 2), SelectionSort.sort(new int[]{2, 1}).getLast());
    }
}
