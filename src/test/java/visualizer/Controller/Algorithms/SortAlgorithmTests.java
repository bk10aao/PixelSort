package visualizer.Controller.Algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SortAlgorithmTests {

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(Commons.testArrayOne, Commons.expectedResultOne),
                new TestCase(Commons.testArrayTwo, Commons.expectedResultTwo),
                new TestCase(Commons.testArrayThree, Commons.expectedResultThree),
                new TestCase(Commons.testArrayFour, Commons.expectedResultFour),
                new TestCase(Commons.testArrayFive, Commons.expectedResultFive),
                new TestCase(Commons.testArraySix, Commons.expectedResultSix),
                new TestCase(Commons.testArraySeven, Commons.expectedResultSeven),
                new TestCase(Commons.testArrayEight, Commons.expectedResultEight),
                new TestCase(Commons.testArrayNine, Commons.expectedResultNine),
                new TestCase(Commons.testArrayTen, Commons.expectedResultTen),
                new TestCase(Commons.testArrayEleven, Commons.expectedResultsEleven),
                new TestCase(Commons.testArrayTwelve, Commons.expectedResultTwelve),
                new TestCase(Commons.testArrayThirteen, Commons.expectedResultThirteen),
                new TestCase(Commons.testArrayFourteen, Commons.expectedResultFourteen),
                new TestCase(Commons.testArrayFifthteen, Commons.expectedResultFifthteen),
                new TestCase(Commons.testArraySixteen, Commons.expectedResultSixteen)
        );
    }

    record TestCase(int[] input, List<Integer> expected) {}

    @ParameterizedTest
    @MethodSource("testCases")
    void testBubbleSort(TestCase tc) {
        assertEquals(tc.expected, BubbleSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testBucketSort(TestCase tc) {
        assertEquals(tc.expected, BucketSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testHeapSort(TestCase tc) {
        assertEquals(tc.expected, HeapSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testInPlaceMergeSort(TestCase tc) {
        assertEquals(tc.expected, InPlaceMergeSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testInsertionSort(TestCase tc) {
        assertEquals(tc.expected, InsertionSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testIntroSort(TestCase tc) {
        assertEquals(tc.expected, IntroSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testMergeSortBottomUp(TestCase tc) {
        assertEquals(tc.expected, MergeSortBottomUp.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testMergeSortTopDown(TestCase tc) {
        assertEquals(tc.expected, MergeSortTopDown.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testPancakeSort(TestCase tc) {
        assertEquals(tc.expected, PancakeSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testParallelMergeSort(TestCase tc) {
        assertEquals(tc.expected, ParallelMergeSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testQuickSort(TestCase tc) {
        assertEquals(tc.expected, QuickSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testRadixLSDSort(TestCase tc) {
        assertEquals(tc.expected, LSDRadixSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testRadixMSDSort(TestCase tc) {
        assertEquals(tc.expected, MSDRadixSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testSelectionSort(TestCase tc) {
        assertEquals(tc.expected, SelectionSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testShellSort(TestCase tc) {
        assertEquals(tc.expected, ShellSort.sort(tc.input).getLast());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testTimSort(TestCase tc) {
        assertEquals(tc.expected, TimSort.sort(tc.input).getLast());
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
}
