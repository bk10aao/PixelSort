package visualizer.Controller.Algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShellSortTest {

    @Test
    public void shellSort_triggerAddOneInGenerateIncrements() {
        assertEquals(List.of(42),  ShellSort.sort(new int[] {42}).getLast());
    }
}
