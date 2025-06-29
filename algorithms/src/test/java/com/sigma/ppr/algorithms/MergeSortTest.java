package com.sigma.ppr.algorithms;

import org.junit.jupiter.api.Test;

import static com.sigma.ppr.algorithms.MergeSort.mergeSort;

public class MergeSortTest extends AlgorithmsBaseTest {

    @Test
    void should_test_and_measure_performance_for_merge_sort() {
        int[] sizes = {1_000, 2_000, 4_000, 8_000, 16_000, 32_000, 64_000};

        System.out.printf("%-10s %-15s %-15s\n", "Size", "Time (ms)", "Time / (n log n)");

        for (int n : sizes) {
            int[] array = generateRandomArray(n);
            long start = System.nanoTime();
            mergeSort(array);
            long end = System.nanoTime();

            double elapsedMs = (end - start) / 1_000_000.0;
            double nLogN = n * Math.log(n) / Math.log(2);
            double ratio = elapsedMs / nLogN;

            System.out.printf("%-10d %-15.3f %-15.6f\n", n, elapsedMs, ratio);
        }
    }
}
