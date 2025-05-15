package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntroSortTest {

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