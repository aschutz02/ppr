package com.sigma.ppr.algorithms;

public class Fibonacci {

    // Big O: Exponential > O(2ⁿ)
    public static long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
