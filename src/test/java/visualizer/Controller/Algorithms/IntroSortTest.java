package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static visualizer.Controller.Algorithms.Commons.callFindPivot;

public class IntroSortTest {
    @Test
    public void introSort_findPivot_returns_2_whenMedianIs_Z() {
        assertEquals(2, callFindPivot(new int[] { 99, 1, 50 }));
    }

    @Test
    public void introSort_findPivot_returns_0_whenMedianIsAtX() {
        assertEquals(0, callFindPivot(new int[] { 50, 1, 99 }));
    }
}
