package com.sigma.ppr.algorithms;

import org.junit.jupiter.api.Test;

public class BinarySearchTest extends AlgorithmsBaseTest {

    @Test
    void should_test_and_measure_performance_for_binary_search() {
        System.out.printf("%-12s %-15s %-15s\n", "Size", "Time (µs)", "Time / log₂(n)");

        for (int n = 1_000; n <= 10_000_000; n *= 10) {
            int[] array = generateSortedArray(n);
            int target = n - 1; // worst case (last element)

            long start = System.nanoTime();
            BinarySearch.search(array, target);
            long end = System.nanoTime();

            double timeMicros = (end - start) / 1_000.0;
            double logN = Math.log(n) / Math.log(2); // log base 2
            double ratio = timeMicros / logN;

            System.out.printf("%-12d %-15.3f %-15.6f\n", n, timeMicros, ratio);
        }
    }
}
