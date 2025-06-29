package com.sigma.ppr.algorithms;

public class MergeSort {

    // Big 0: Linearithymic > O(n log n)
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // it is already ordered
        }

        int mid = array.length / 2;

        // Split the array in half
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Copies the elements to the left and right arrays
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        // Recursively sorts the two halves
        mergeSort(left);
        mergeSort(right);

        // Merge the arrays
        merge(array, left, right);
    }

    // Function that joins two sorted arrays into a single sorted array
    public static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Join the smallest elements on each side
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copies the remaining elements (if any)
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}

