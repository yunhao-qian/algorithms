package org.yunhaoqian.algorithms;

public class LSD {
    /**
     * Least significant digit (LSD) radix sort.
     *
     * @param a Array to be sorted. The string lengths must be equal.
     * @param W String length.
     */
    public static void sort(String[] a, int W) {
        int N = a.length;
        // Alphabet size. Accept char code from 0 to R - 1.
        int R = 256;
        // Out-of-place sorting.
        String[] aux = new String[N];

        // Sort by the d's digit in each iteration.
        for (int d = W - 1; d >= 0; --d) {
            int[] count = new int[R + 1];
            // Count the frequencies of keys. The 0'th place remains empty.
            for (int i = 0; i < N; ++i)
                ++count[a[i].charAt(d) + 1];
            // Convert frequencies to starting indices.
            for (int r = 1; r < R; ++r)
                count[r] += count[r - 1];
            // Sort the array in aux.
            for (int i = 0; i < N; ++i)
                aux[count[a[i].charAt(d)]++] = a[i];
            // Copy aux back to a.
            for (int i = 0; i < N; ++i)
                a[i] = aux[i];
        }
    }
}