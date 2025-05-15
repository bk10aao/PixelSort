package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSortTests {

    @Test
    public void mergeSortBottomUp_givenReversedArray_onSort_hitsAllMergeBranches() {
        assertEquals(List.of(1, 2, 3, 4, 5), MergeSortBottomUp.sort(new int[]{5, 4, 3, 2, 1}).getLast());
    }

    @Test
    public void mergeSortTopDown_givenReversedArray_onSort_hitsAllMergeBranches() {
        assertEquals(List.of(1, 2, 3, 4, 5), MergeSortTopDown.sort(new int[]{5, 4, 3, 2, 1}).getLast());
    }

    @Test
    public void parallelMergeSort_givenRightSubArrayExhausted_onSort_returnsSortedArray() {
        assertEquals(List.of(1, 2, 3, 4), ParallelMergeSort.sort(new int[]{1, 2, 4, 3}).getLast());
    }
}
