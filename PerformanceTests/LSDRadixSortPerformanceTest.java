package visualizer.Controller.Algorithms.PerformanceTests;

import visualizer.Controller.Algorithms.LSDRadixSort;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class LSDRadixSortPerformanceTest {
    public static void main(String[] args) {
        // Input sizes to test
        int[] sizes = { 250, 500, 1000, 2500, 5000, 10000 };        // Store results
        // Store results
        ArrayList<long[]> results = new ArrayList<>();
        Random random = new Random();

        for (int size : sizes) {
            System.out.println("Testing size: " + size);
            // Pre-generate data for consistent testing
            int[] array = generateArray(size, random);

            // Benchmark sort method
            long sortTime = benchmarkSort(array);

            // Store results (in nanoseconds)
            results.add(new long[]{size, sortTime});
        }

        // Write results to CSV
        try (FileWriter writer = new FileWriter("LSDRadixSort_performance_data.csv")) {
            writer.write("Size,SortTime\n");
            for (long[] result : results) {
                writer.write(String.format("%d,%d\n", result[0], result[1]));
            }
            System.out.println("Performance data written to BubbleSort_performance_data.csv");
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }

    private static long benchmarkSort(int[] array) {
        int[] arrayCopy = array.clone();
        long start = System.nanoTime();
        LSDRadixSort.sort(arrayCopy);
        return System.nanoTime() - start;
    }

    private static int[] generateArray(int size, Random random) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}