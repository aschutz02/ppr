package com.sigma.ppr.algorithms;

import org.junit.jupiter.api.Test;

public class SelectionSortTest extends AlgorithmsBaseTest {

    @Test
    void should_test_and_measure_performance_for_selection_sort() {
        int[] sizes = {500, 1000, 2000, 3000, 4000};

        System.out.printf("%-10s %-15s %-15s\n", "Size", "Time (ms)", "Time / n²");

        for (int n : sizes) {
            int[] array = generateRandomArray(n);
            long start = System.nanoTime();
            SelectionSort.selectionSort(array);
            long end = System.nanoTime();

            double elapsedMs = (end - start) / 1_000_000.0;
            double nSquared = (double) n * n;
            double ratio = elapsedMs / nSquared;

            System.out.printf("%-10d %-15.3f %-15.9f\n", n, elapsedMs, ratio);
        }
    }
}
