package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

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

public class InsertionSortTest {

    @Test
    public void givenAnEmptyArray_onSort_returnsEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> InsertionSort.sort(new int[]{}));
    }

    @Test
    public void givenNullArray_onSort_returnsEmptyList() {
        assertThrows(NullPointerException.class, ()-> InsertionSort.sort(null));
    }

    @Test
    public void givenTestArrayOne_onSort_returnsSortedListOne() {
        assertEquals(expectedResultOne, InsertionSort.sort(testArrayOne).getLast());
    }

    @Test
    public void givenTestArrayTwo_onSort_returnsSortedListTwo() {
        assertEquals(expectedResultTwo, InsertionSort.sort(testArrayTwo).getLast());
    }

    @Test
    public void givenTestArrayThree_onSort_returnsSortedListThree() {
        assertEquals(expectedResultThree, InsertionSort.sort(testArrayThree).getLast());
    }

    @Test
    public void givenTestArrayFour_onSort_returnsSortedListFour() {
        assertEquals(expectedResultFour, InsertionSort.sort(testArrayFour).getLast());
    }

    @Test
    public void givenTestArrayFive_onSort_returnsSortedListFive() {
        assertEquals(expectedResultFive, InsertionSort.sort(testArrayFive).getLast());
    }

    @Test
    public void givenTestArraySix_onSort_returnsSortedListSix() {
        assertEquals(expectedResultSix, InsertionSort.sort(testArraySix).getLast());
    }

    @Test
    public void givenTestArraySeven_onSort_returnsSortedListSeven() {
        assertEquals(expectedResultSeven, InsertionSort.sort(testArraySeven).getLast());
    }
}