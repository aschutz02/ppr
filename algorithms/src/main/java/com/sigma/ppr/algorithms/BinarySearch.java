package com.sigma.ppr.algorithms;

public class BinarySearch {

    // Big O: Logarithmic > O(log n)
    public static int search(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int half = start + (end - start) / 2;

            if (array[half] == target) {
                return half;
            } else if (array[half] < target) {
                start = half + 1;
            } else {
                end = half - 1;
            }
        }

        return -1; // Not found
    }
}
