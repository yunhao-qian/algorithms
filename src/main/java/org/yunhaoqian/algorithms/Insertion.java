package org.yunhaoqian.algorithms;

public class Insertion {
    /**
     * Compare two strings with a common prefix.
     *
     * @param s1 The first string.
     * @param s2 The second string.
     * @param d The first {@code d} characters of the two strings are the same.
     * @return Whether {@code s1} is less than {@code s2} by dictionary ordering.
     */
    private static boolean less(String s1, String s2, int d) {
        return s1.substring(d).compareTo(s2.substring(d)) < 0;
    }

    /**
     * Insertion sort modified for MSD radix sort. Sort a string subarray.
     *
     * @param a Array to be sorted.
     * @param lo Starting index of the subarray.
     * @param hi Ending index of the subarray.
     * @param d Sort by the {@code d}'s character of each string.
     */
    static void sort(String[] a, int lo, int hi, int d) {
        for (int i = lo + 1; i < hi; ++i)
            for (int j = i; j > lo && less(a[j], a[j - 1], d); --j)
                Utility.swap(a, j, j - 1);
    }
}