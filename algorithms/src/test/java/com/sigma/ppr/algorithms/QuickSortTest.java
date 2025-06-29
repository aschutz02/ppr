package com.sigma.ppr.algorithms;

import org.junit.jupiter.api.Test;

public class QuickSortTest extends AlgorithmsBaseTest {

    @Test
    void should_test_and_measure_performance_for_quick_sort() {
        int[] sizes = {1_000, 2_000, 4_000, 8_000, 16_000, 32_000, 64_000};

        System.out.printf("%-10s %-15s %-15s\n", "Size", "Time (ms)", "Time / (n log n)");

        for (int n : sizes) {
            int[] array = generateRandomArray(n);
            long start = System.nanoTime();
            QuickSort.quickSort(array, 0, array.length - 1);
            long end = System.nanoTime();

            double elapsedMs = (end - start) / 1_000_000.0;
            double nLogN = n * Math.log(n) / Math.log(2);
            double ratio = elapsedMs / nLogN;

            System.out.printf("%-10d %-15.3f %-15.6f\n", n, elapsedMs, ratio);
        }
    }

    @Test
    void should_test_and_measure_performance_for_quick_sort_in_worst_case() {

        int[] sizes = {1_000, 2_000, 4_000, 8_000, 16_000};

        System.out.printf("%-10s %-15s %-15s\n", "Size", "Time (ms)", "Time / (n²)");

        for (int n : sizes) {
            int[] array = generateSortedArray(n); // worst case: ascending sorted array
            long start = System.nanoTime();
            QuickSort.quickSort(array, 0, array.length - 1);
            long end = System.nanoTime();

            double elapsedMs = (end - start) / 1_000_000.0;
            double nSquared = (double) n * n;
            double ratio = elapsedMs / nSquared;

            System.out.printf("%-10d %-15.3f %-15.9f\n", n, elapsedMs, ratio);
        }
    }
}
