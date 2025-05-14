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
import static visualizer.Controller.Algorithms.Commons.testIntegerArrayFive;
import static visualizer.Controller.Algorithms.Commons.testIntegerArrayFour;
import static visualizer.Controller.Algorithms.Commons.testIntegerArrayOne;
import static visualizer.Controller.Algorithms.Commons.testIntegerArraySeven;
import static visualizer.Controller.Algorithms.Commons.testIntegerArraySix;
import static visualizer.Controller.Algorithms.Commons.testIntegerArrayThree;
import static visualizer.Controller.Algorithms.Commons.testIntegerArrayTwo;

class MSDRadixSortTest {

    @Test
    public void givenAnEmptyArray_onSort_returnsEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> MSDRadixSort.sort(new Integer[]{}));
    }

    @Test
    public void givenNullArray_onSort_returnsEmptyList() {
        assertThrows(NullPointerException.class, ()-> MSDRadixSort.sort(null));
    }

    @Test
    public void givenTestArrayOne_onSort_returnsSortedListOne() {
        assertEquals(expectedResultOne, MSDRadixSort.sort(testIntegerArrayOne).getLast());
    }

    @Test
    public void givenTestArrayTwo_onSort_returnsSortedListTwo() {
        assertEquals(expectedResultTwo, MSDRadixSort.sort(testIntegerArrayTwo).getLast());
    }

    @Test
    public void givenTestArrayThree_onSort_returnsSortedListThree() {
        assertEquals(expectedResultThree, MSDRadixSort.sort(testIntegerArrayThree).getLast());
    }

    @Test
    public void givenTestArrayFour_onSort_returnsSortedListFour() {
        assertEquals(expectedResultFour, MSDRadixSort.sort(testIntegerArrayFour).getLast());
    }

    @Test
    public void givenTestArrayFive_onSort_returnsSortedListFive() {
        assertEquals(expectedResultFive, MSDRadixSort.sort(testIntegerArrayFive).getLast());
    }

    @Test
    public void givenTestArraySix_onSort_returnsSortedListSix() {
        assertEquals(expectedResultSix, MSDRadixSort.sort(testIntegerArraySix).getLast());
    }

    @Test
    public void givenTestArraySeven_onSort_returnsSortedListSeven() {
        assertEquals(expectedResultSeven, MSDRadixSort.sort(testIntegerArraySeven).getLast());
    }
}