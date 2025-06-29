package com.sigma.ppr.algorithms;

import org.junit.jupiter.api.Test;

public class PermutationTest {

    @Test
    void should_test_and_measure_performance_for_permutation() {
        System.out.printf("%-10s %-15s %-15s\n", "n", "Time (ms)", "Time / n!");

        for (int n = 5; n <= 10; n++) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) array[i] = i + 1;

            long start = System.nanoTime();
            Permutation.permutation(array);
            long end = System.nanoTime();

            double elapsedMs = (end - start) / 1_000_000.0;
            double factorial = factorial(n);
            double ratio = elapsedMs / factorial;

            System.out.printf("%-10d %-15.3f %-15.9f\n", n, elapsedMs, ratio);
        }
    }

    private static long factorial(int n) {
        long fat = 1;
        for (int i = 2; i <= n; i++) fat *= i;
        return fat;
    }
}
