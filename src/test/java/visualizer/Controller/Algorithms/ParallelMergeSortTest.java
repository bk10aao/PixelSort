package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParallelMergeSortTest {

    @Test
    public void givenReversedArray_onSort_hitsAllMergeBranches() {
        assertEquals(List.of(1, 2, 3, 4, 5), ParallelMergeSort.sort(new int[]{5, 4, 3, 2, 1}).getLast());
    }

    @Test
    public void givenTwoElementSortedArray_onSort_returnsSortedArray() {
        assertEquals(List.of(1, 2), ParallelMergeSort.sort(new int[]{1, 2}).getLast());
    }

    @Test
    public void givenLeftSubarrayExhausted_onSort_returnsSortedArray() {
        assertEquals(List.of(1, 2, 3, 4), ParallelMergeSort.sort(new int[]{3, 4, 1, 2}).getLast());
    }

    @Test
    public void givenRightSubarrayExhausted_onSort_returnsSortedArray() {
        assertEquals(List.of(1, 2, 3, 4), ParallelMergeSort.sort(new int[]{1, 2, 4, 3}).getLast());
    }
}