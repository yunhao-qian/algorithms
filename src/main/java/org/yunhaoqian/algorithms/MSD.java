package org.yunhaoqian.algorithms;

public class MSD {
    private static final int R = 256;

    // Switch to selection sort if the subarray length is less than M.
    private static final int M = 15;

    // aux is not allocated for each recursion to improve performance.
    private static String[] aux;

    /**
     * Return the character of a given index in a string; or -1 if it does not
     * exist.
     *
     * @param s The string.
     * @param d The index.
     * @return Char code of the {@code d}'s character in {@code s}. {@code -1}
     * if the index is out of range.
     */
    static int charAt(String s, int d) {
        return d < s.length() ? s.charAt(d) : -1;
    }

    /**
     * Most significant digit (MSD) radix sort.
     *
     * @param a Array to be sorted.
     */
    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N, 0);
    }

    /**
     * Sort a string subarray by the characters of a given index.
     *
     * @param a  Array to be sorted.
     * @param lo Starting index of the subarray.
     * @param hi Ending index of the subarray.
     * @param d  Sort by the {@code d}'s character of each string.
     */
    private static void sort(String[] a, int lo, int hi, int d) {
        // Switch to insertion sort for short subarrays.
        if (lo + M >= hi) {
            Insertion.sort(a, lo, hi, d);
            return;
        }
        // Count the frequencies of keys.
        int[] count = new int[R + 2];
        for (int i = lo; i < hi; ++i)
            ++count[charAt(a[i], d) + 2];
        // Convert indices to starting indices.
        count[0] = lo;
        for (int r = 0; r < R; ++r)
            count[r + 1] += count[r];
        // Sort the array in aux.
        for (int i = lo; i < hi; ++i)
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        // Copy aux back to a.
        for (int i = lo; i < hi; ++i)
            a[i] = aux[i];
        // The iteration terminates when d exceeds the length of the longest
        // string in a. Strings with length d are skipped.
        for (int i = 0; i < R; ++i)
            sort(a, count[i], count[i + 1], d + 1);
    }
}