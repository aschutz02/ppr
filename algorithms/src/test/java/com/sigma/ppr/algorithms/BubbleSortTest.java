package com.sigma.ppr.algorithms;

import org.junit.jupiter.api.Test;

public class BubbleSortTest extends AlgorithmsBaseTest {

    @Test
    void should_test_and_measure_performance_for_bubble_sort() {
        int[] sizes = {500, 1000, 2000, 3000, 4000}; // bubble sort is slow

        System.out.printf("%-10s %-15s %-15s\n", "Size", "Tempo (ms)", "Time / n²");

        for (int n : sizes) {
            int[] array = generateReverseSortedArray(n); // worst case
            long start = System.nanoTime();
            BubbleSort.bubbleSort(array);
            long end = System.nanoTime();

            double elapsedMs = (end - start) / 1_000_000.0;
            double nSquared = (double) n * n;
            double ratio = elapsedMs / nSquared;

            System.out.printf("%-10d %-15.3f %-15.9f\n", n, elapsedMs, ratio);
        }
    }
}
