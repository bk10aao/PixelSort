package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeSortBottomUpTest {

    @Test
    public void givenReversedArray_onSort_hitsAllMergeBranches() {
        assertEquals(List.of(1, 2, 3, 4, 5), MergeSortBottomUp.sort(new int[]{5, 4, 3, 2, 1}).getLast());
    }

    @Test
    public void givenTwoElementSortedArray_onSort_returnsSortedArray() {
        assertEquals(List.of(1, 2), MergeSortBottomUp.sort(new int[]{1, 2}).getLast());
    }

    @Test
    public void givenLeftSubarrayExhausted_onSort_returnsSortedArray() {
        assertEquals(List.of(1, 2, 3, 4), MergeSortBottomUp.sort(new int[]{3, 4, 1, 2}).getLast());
    }

    @Test
    public void givenRightSubarrayExhausted_onSort_returnsSortedArray() {
        assertEquals(List.of(1, 2, 3, 4), MergeSortBottomUp.sort(new int[]{1, 2, 4, 3}).getLast());
    }
}