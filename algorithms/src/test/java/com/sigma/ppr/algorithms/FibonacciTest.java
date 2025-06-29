package com.sigma.ppr.algorithms;

import org.junit.jupiter.api.Test;

public class FibonacciTest {

    @Test
    void should_test_and_measure_performance_for_fibonacci() {
        System.out.printf("%-10s %-15s %-15s\n", "n", "Time (ms)", "Time / 2^n");

        for (int n = 10; n <= 45; n += 5) {
            long start = System.nanoTime();
            Fibonacci.fibonacci(n);
            long end = System.nanoTime();

            double elapsedMs = (end - start) / 1_000_000.0;
            double ratio = elapsedMs / Math.pow(2, n);

            System.out.printf("%-10d %-15.3f %-15.9f\n", n, elapsedMs, ratio);
        }
    }
}
