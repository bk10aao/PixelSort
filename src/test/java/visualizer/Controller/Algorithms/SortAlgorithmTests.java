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
                new TestCase(Commons.testArrayEight, Commons.expectedResultEight)
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

    // Add common tests for exceptions once, if needed
    @Test
    void testEmptyInputThrows() {
        assertThrows(IllegalArgumentException.class, () -> BubbleSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> HeapSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> BucketSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> InPlaceMergeSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> InsertionSort.sort(new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> IntroSort.sort(new int[] {}));
    }

    @Test
    void testNullInputThrows() {
        assertThrows(NullPointerException.class, () -> BubbleSort.sort(null));
        assertThrows(NullPointerException.class, () -> HeapSort.sort(null));
        assertThrows(NullPointerException.class, () -> BucketSort.sort(null));
        assertThrows(NullPointerException.class, () -> InPlaceMergeSort.sort(null));
        assertThrows(NullPointerException.class, () -> InsertionSort.sort(null));
        assertThrows(NullPointerException.class, () -> IntroSort.sort(null));
    }
}
