package com.sigma.ppr.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    // Big O: Factorial > O(n!)
    public static List<List<Integer>> permutation(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(array, 0, result);
        return result;
    }

    private static void backtrack(int[] array, int start, List<List<Integer>> result) {
        if (start == array.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : array) permutation.add(num);
            result.add(permutation);
        } else {
            for (int i = start; i < array.length; i++) {
                swap(array, start, i);
                backtrack(array, start + 1, result);
                swap(array, start, i);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
