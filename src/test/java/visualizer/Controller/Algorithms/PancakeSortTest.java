package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static visualizer.Controller.Algorithms.Commons.expectedResultEight;
import static visualizer.Controller.Algorithms.Commons.expectedResultFive;
import static visualizer.Controller.Algorithms.Commons.expectedResultFour;
import static visualizer.Controller.Algorithms.Commons.expectedResultOne;
import static visualizer.Controller.Algorithms.Commons.expectedResultSeven;
import static visualizer.Controller.Algorithms.Commons.expectedResultSix;
import static visualizer.Controller.Algorithms.Commons.expectedResultThree;
import static visualizer.Controller.Algorithms.Commons.expectedResultTwo;
import static visualizer.Controller.Algorithms.Commons.testArrayEight;
import static visualizer.Controller.Algorithms.Commons.testArrayFive;
import static visualizer.Controller.Algorithms.Commons.testArrayFour;
import static visualizer.Controller.Algorithms.Commons.testArrayOne;
import static visualizer.Controller.Algorithms.Commons.testArraySeven;
import static visualizer.Controller.Algorithms.Commons.testArraySix;
import static visualizer.Controller.Algorithms.Commons.testArrayThree;
import static visualizer.Controller.Algorithms.Commons.testArrayTwo;

class PancakeSortTest {

    @Test
    public void givenAnEmptyArray_onSort_returnsEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> PancakeSort.sort(new int[]{}));
    }

    @Test
    public void givenNullArray_onSort_returnsEmptyList() {
        assertThrows(NullPointerException.class, ()-> PancakeSort.sort(null));
    }

    @Test
    public void givenTestArrayOne_onSort_returnsSortedListOne() {
        assertEquals(expectedResultOne, PancakeSort.sort(testArrayOne).getLast());
    }

    @Test
    public void givenTestArrayTwo_onSort_returnsSortedListTwo() {
        assertEquals(expectedResultTwo, PancakeSort.sort(testArrayTwo).getLast());
    }

    @Test
    public void givenTestArrayThree_onSort_returnsSortedListThree() {
        assertEquals(expectedResultThree, PancakeSort.sort(testArrayThree).getLast());
    }

    @Test
    public void givenTestArrayFour_onSort_returnsSortedListFour() {
        assertEquals(expectedResultFour, PancakeSort.sort(testArrayFour).getLast());
    }

    @Test
    public void givenTestArrayFive_onSort_returnsSortedListFive() {
        assertEquals(expectedResultFive, PancakeSort.sort(testArrayFive).getLast());
    }

    @Test
    public void givenTestArraySix_onSort_returnsSortedListSix() {
        assertEquals(expectedResultSix, PancakeSort.sort(testArraySix).getLast());
    }

    @Test
    public void givenTestArraySeven_onSort_returnsSortedListSeven() {
        assertEquals(expectedResultSeven, PancakeSort.sort(testArraySeven).getLast());
    }

    @Test
    public void givenTestArrayEight_onSort_returnsSortedListEight() {
        assertEquals(expectedResultEight, PancakeSort.sort(testArrayEight).getLast());
    }
}