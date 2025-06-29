package com.sigma.ppr.algorithms;

public class BubbleSort {

    // Big O: Quadratic > Best case O(n) (when array is sorted) and worst case O(n²) (array in reverse order)
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // swaps
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps were made, the array is already sorted.
            if (!swapped) break;
        }
    }
}

