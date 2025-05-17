package visualizer.Controller.Algorithms.Algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static visualizer.Controller.Algorithms.Utilities.Utils.callFindPivot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import visualizer.Controller.Algorithms.BubbleSort;
import visualizer.Controller.Algorithms.BucketSort;
import visualizer.Controller.Algorithms.HeapSort;
import visualizer.Controller.Algorithms.InPlaceMergeSort;
import visualizer.Controller.Algorithms.InsertionSort;
import visualizer.Controller.Algorithms.IntroSort;
import visualizer.Controller.Algorithms.LSDRadixSort;
import visualizer.Controller.Algorithms.MSDRadixSort;
import visualizer.Controller.Algorithms.MergeSortBottomUp;
import visualizer.Controller.Algorithms.MergeSortTopDown;
import visualizer.Controller.Algorithms.PancakeSort;
import visualizer.Controller.Algorithms.ParallelMergeSort;
import visualizer.Controller.Algorithms.QuickSort;
import visualizer.Controller.Algorithms.SelectionSort;
import visualizer.Controller.Algorithms.ShellSort;
import visualizer.Controller.Algorithms.TimSort;
import visualizer.Controller.Algorithms.Utilities.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SortAlgorithmTests {

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(Utils.testArrayOne, Utils.expectedResultOne),
                new TestCase(Utils.testArrayTwo, Utils.expectedResultTwo),
                new TestCase(Utils.testArrayThree, Utils.expectedResultThree),
                new TestCase(Utils.testArrayFour, Utils.expectedResultFour),
                new TestCase(Utils.testArrayFive, Utils.expectedResultFive),
                new TestCase(Utils.testArraySix, Utils.expectedResultSix),
                new TestCase(Utils.testArraySeven, Utils.expectedResultSeven),
                new TestCase(Utils.testArrayEight, Utils.expectedResultEight),
                new TestCase(Utils.testArrayNine, Utils.expectedResultNine),
                new TestCase(Utils.testArrayTen, Utils.expectedResultTen),
                new TestCase(Utils.testArrayEleven, Utils.expectedResultsEleven),
                new TestCase(Utils.testArrayTwelve, Utils.expectedResultTwelve),
                new TestCase(Utils.testArrayThirteen, Utils.expectedResultThirteen),
                new TestCase(Utils.testArrayFourteen, Utils.expectedResultFourteen),
                new TestCase(Utils.testArrayFifteen, Utils.expectedResultFifteen),
                new TestCase(Utils.testArraySixteen, Utils.expectedResultSixteen),
                new TestCase(Utils.testArraySeventeen, Utils.expectedResultSeventeen),
                new TestCase(Utils.testArrayEighteen, Utils.expectedResultEighteen),
                new TestCase(Utils.testArrayNineteen, Utils.expectedResultNineteen)
        );
    }

    record TestCase(int[] input, List<Integer> expected) {}

    @ParameterizedTest
    @MethodSource("testCases")
    void testBubbleSort(TestCase tc) {
        Assertions.assertEquals(tc.expected, BubbleSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testBucketSort(TestCase tc) {
        Assertions.assertEquals(tc.expected, BucketSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testHeapSort(TestCase tc) {
        Assertions.assertEquals(tc.expected, HeapSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testInPlaceMergeSort(TestCase tc) {
        Assertions.assertEquals(tc.expected, InPlaceMergeSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testInsertionSort(TestCase tc) {
        Assertions.assertEquals(tc.expected, InsertionSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testIntroSort(TestCase tc) {
        Assertions.assertEquals(tc.expected, IntroSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testMergeSortBottomUp(TestCase tc) {
        Assertions.assertEquals(tc.expected, MergeSortBottomUp.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testMergeSortTopDown(TestCase tc) {
        Assertions.assertEquals(tc.expected, MergeSortTopDown.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testPancakeSort(TestCase tc) {
        Assertions.assertEquals(tc.expected, PancakeSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testParallelMergeSort(TestCase tc) {
        Assertions.assertEquals(tc.expected, ParallelMergeSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testQuickSort(TestCase tc) {
        Assertions.assertEquals(tc.expected, QuickSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testRadixLSDSort(TestCase tc) {
        Assertions.assertEquals(tc.expected, LSDRadixSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testRadixMSDSort(TestCase tc) {
        Assertions.assertEquals(tc.expected, MSDRadixSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testSelectionSort(TestCase tc) {
        Assertions.assertEquals(tc.expected, SelectionSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testShellSort(TestCase tc) {
        Assertions.assertEquals(tc.expected, ShellSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testTimSort(TestCase tc) {
        Assertions.assertEquals(tc.expected, TimSort.sort(tc.input).getLast());
    }

    @Test
    void testEmptyInputThrows() {
        assertThrows(IllegalArgumentException.class, () -> BubbleSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> HeapSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> BucketSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> InPlaceMergeSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> InsertionSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> IntroSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> MergeSortBottomUp.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> MergeSortTopDown.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> PancakeSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> ParallelMergeSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> QuickSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> SelectionSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> ShellSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> TimSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> LSDRadixSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> MSDRadixSort.sort(new int[] {}));
    }

    @Test
    void testNullInputThrows() {
        assertThrows(NullPointerException.class, () -> BubbleSort.sort(null));
        assertThrows(NullPointerException.class, () -> HeapSort.sort(null));
        assertThrows(NullPointerException.class, () -> BucketSort.sort(null));
        assertThrows(NullPointerException.class, () -> InPlaceMergeSort.sort(null));
        assertThrows(NullPointerException.class, () -> InsertionSort.sort(null));
        assertThrows(NullPointerException.class, () -> IntroSort.sort(null));
        assertThrows(NullPointerException.class, () -> MergeSortBottomUp.sort(null));
        assertThrows(NullPointerException.class, () -> MergeSortTopDown.sort(null));
        assertThrows(NullPointerException.class, () -> PancakeSort.sort(null));
        assertThrows(NullPointerException.class, () -> ParallelMergeSort.sort(null));
        assertThrows(NullPointerException.class, () -> QuickSort.sort(null));
        assertThrows(NullPointerException.class, () -> SelectionSort.sort(null));
        assertThrows(NullPointerException.class, () -> ShellSort.sort(null));
        assertThrows(NullPointerException.class, () -> TimSort.sort(null));
        assertThrows(NullPointerException.class, () -> LSDRadixSort.sort(null));
        assertThrows(NullPointerException.class, () -> MSDRadixSort.sort(null));
    }

    @Test
    public void introSort_findPivot_returns_2_whenMedianIs_Z() {
        assertEquals(2, callFindPivot(new int[] { 99, 1, 50 }));
    }

    @Test
    public void introSort_findPivot_returns_0_whenMedianIsAtX() {
        assertEquals(0, callFindPivot(new int[] { 50, 1, 99 }));
    }

    @Test
    public void timSort_triggersRunStackMergeLogicWithLargeInput() {
        int[] input = new int[40];
        for (int i = 0; i < 10; i++)
            input[i] = i + 1;
        for (int i = 10; i < 20; i++)
            input[i] = 30 - i;
        for (int i = 20; i < 40; i++)
            input[i] = i + 1;
        int[] sorted = input.clone();
        Arrays.sort(sorted);
        assertEquals(List.of(java.util.Arrays.stream(sorted).boxed().toArray(Integer[]::new)), TimSort.sort(input).getLast());
    }
}
