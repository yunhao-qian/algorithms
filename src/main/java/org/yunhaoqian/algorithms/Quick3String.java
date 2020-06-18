package org.yunhaoqian.algorithms;

public class Quick3String {
    // Switch to selection sort if the subarray length is less than M.
    private static final int M = 15;

    /**
     * Three-way string quick sort.
     *
     * @param a Array to be sorted.
     */
    public static void sort(String[] a) {
        sort(a, 0, a.length, 0);
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
        // Switch to insertion sort for short sub-arrays.
        if (lo + M >= hi) {
            Insertion.sort(a, lo, hi, d);
            return;
        }
        // lo ~ lt - 1: < v;
        // lt ~ i - 1:  = v;
        // i  ~ gt - 1: unknown;
        // gt ~ hi - 1: > v.
        int lt = lo, gt = hi;
        // Choose the first element in the sub-array as pivot.
        int v = Utility.charAt(a[lo], d);
        int i = lo + 1;
        while (i < gt) {
            int t = Utility.charAt(a[i], d);
            if (t < v)
                Utility.swap(a, lt++, i++);
            else if (t > v)
                Utility.swap(a, i, --gt);
            else
                ++i;
        }
        sort(a, lo, lt, d);
        // Stop recursion if the pivot key reaches its end.
        if (v > 0)
            sort(a, lt, gt, d + 1);
        sort(a, gt, hi, d);
    }
}