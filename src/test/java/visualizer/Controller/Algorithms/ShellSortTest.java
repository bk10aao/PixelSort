package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShellSortTest {

    @Test
    public void triggerInnerLoopInHSort() {
        assertEquals(List.of(1, 5), ShellSort.sort(new int[] {5, 1}).getLast());
    }

    @Test
    public void triggerAddOneInGenerateIncrements() {
        assertEquals(List.of(42),  ShellSort.sort(new int[] {42}).getLast());
    }
}