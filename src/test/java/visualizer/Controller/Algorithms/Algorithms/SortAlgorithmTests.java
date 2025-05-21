package visualizer.Controller.Algorithms.Algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static visualizer.Controller.Algorithms.Utilities.Utils.callFindPivot;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultEight;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultEighteen;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultFifteen;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultFive;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultFour;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultFourteen;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultNine;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultNineteen;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultOne;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultSeven;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultSeventeen;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultSix;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultSixteen;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultTen;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultThirteen;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultThree;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultTwelve;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultTwenty;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultTwentyOne;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultTwentyThree;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultTwentyTwo;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultTwo;
import static visualizer.Controller.Algorithms.Utilities.Utils.expectedResultsEleven;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayEight;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayEighteen;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayEleven;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayFifteen;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayFive;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayFour;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayFourteen;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayNine;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayNineteen;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayOne;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArraySeven;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArraySeventeen;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArraySix;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArraySixteen;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayTen;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayThirteen;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayThree;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayTwelve;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayTwenty;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayTwentyOne;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayTwentyThree;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayTwentyTwo;
import static visualizer.Controller.Algorithms.Utilities.Utils.testArrayTwo;

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

import java.util.List;
import java.util.stream.Stream;

public class SortAlgorithmTests {

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(testArrayOne, expectedResultOne),
                new TestCase(testArrayTwo, expectedResultTwo),
                new TestCase(testArrayThree, expectedResultThree),
                new TestCase(testArrayFour, expectedResultFour),
                new TestCase(testArrayFive, expectedResultFive),
                new TestCase(testArraySix, expectedResultSix),
                new TestCase(testArraySeven, expectedResultSeven),
                new TestCase(testArrayEight, expectedResultEight),
                new TestCase(testArrayNine, expectedResultNine),
                new TestCase(testArrayTen, expectedResultTen),
                new TestCase(testArrayEleven, expectedResultsEleven),
                new TestCase(testArrayTwelve, expectedResultTwelve),
                new TestCase(testArrayThirteen, expectedResultThirteen),
                new TestCase(testArrayFourteen, expectedResultFourteen),
                new TestCase(testArrayFifteen, expectedResultFifteen),
                new TestCase(testArraySixteen, expectedResultSixteen),
                new TestCase(testArraySeventeen, expectedResultSeventeen),
                new TestCase(testArrayEighteen, expectedResultEighteen),
                new TestCase(testArrayNineteen, expectedResultNineteen),
                new TestCase(testArrayTwenty, expectedResultTwenty),
                new TestCase(testArrayTwentyOne, expectedResultTwentyOne),
                new TestCase(testArrayTwentyTwo, expectedResultTwentyTwo),
                new TestCase(testArrayTwentyThree, expectedResultTwentyThree)
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

        assertEquals(expectedResultTwentyTwo, TimSort.sort(testArrayTwentyTwo).getLast());
    }
}
