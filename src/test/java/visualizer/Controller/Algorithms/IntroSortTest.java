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

public class IntroSortTest {

//    @Test
//    public void givenAnEmptyArray_onSort_returnsEmptyList() {
//        assertThrows(IllegalArgumentException.class, () -> IntroSort.sort(new int[]{}));
//    }
//
//    @Test
//    public void givenNullArray_onSort_returnsEmptyList() {
//        assertThrows(NullPointerException.class, ()-> IntroSort.sort(null));
//    }
//
//    @Test
//    public void givenTestArrayOne_onSort_returnsSortedListOne() {
//        assertEquals(expectedResultOne, IntroSort.sort(testArrayOne).getLast());
//    }
//
//    @Test
//    public void givenTestArrayTwo_onSort_returnsSortedListTwo() {
//        assertEquals(expectedResultTwo, IntroSort.sort(testArrayTwo).getLast());
//    }
//
//    @Test
//    public void givenTestArrayThree_onSort_returnsSortedListThree() {
//        assertEquals(expectedResultThree, IntroSort.sort(testArrayThree).getLast());
//    }
//
//    @Test
//    public void givenTestArrayFour_onSort_returnsSortedListFour() {
//        assertEquals(expectedResultFour, IntroSort.sort(testArrayFour).getLast());
//
//    }
//
//    @Test
//    public void givenTestArrayOf200Items_onSort_returnsSortedListFour() {
//        assertEquals(expectedResultFive, IntroSort.sort(testArrayFive).getLast());
//    }
//
//    @Test
//    public void givenTestArrayFive_onSort_returnsSortedListFive() {
//        assertEquals(expectedResultFive, IntroSort.sort(testArrayFive).getLast());
//    }
//
//    @Test
//    public void givenTestArraySix_onSort_returnsSortedListSix() {
//        assertEquals(expectedResultSix, IntroSort.sort(testArraySix).getLast());
//    }
//
//    @Test
//    public void givenTestArraySeven_onSort_returnsSortedListSeven() {
//        assertEquals(expectedResultSeven, IntroSort.sort(testArraySeven).getLast());
//    }
//
//    @Test
//    public void givenTestArrayEight_onSort_returnsSortedListEight() {
//        assertEquals(expectedResultEight, IntroSort.sort(testArrayEight).getLast());
//    }

    @Test
    public void findPivot_returnsZ_whenMedianIsAtZ() {
        assertEquals(2, callFindPivot(new int[] { 99, 1, 50 }, 0, 1, 2));
    }

    @Test
    public void findPivot_returnsX_whenMedianIsAtX() {
        assertEquals(0, callFindPivot(new int[] { 50, 1, 99 } , 0, 1, 2));
    }

    private int callFindPivot(int[] values, int x, int y, int z) {
        try {
            java.lang.reflect.Method method = IntroSort.class.getDeclaredMethod("findPivot", int[].class, int.class, int.class, int.class);
            method.setAccessible(true);
            return (int) method.invoke(null, values, x, y, z);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}