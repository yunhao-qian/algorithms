package org.yunhaoqian.algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Quick3StringTest {
    private static final String[] fileNames = new String[]{
            "chromosome4.txt",
            "chromosome11.txt",
            "commonwords.txt",
            "ospd.txt",
            "wordlist.txt"
    };

    private String[][] arrays;

    /**
     * Initialize the array of string arrays. They hold the lines from files
     * whose names are from {@fileNames}.
     *
     * @throws Exception
     */
    @Before
    public void initArrays() throws Exception {
        arrays = new String[fileNames.length][];
        for (int i = 0; i < fileNames.length; ++i) {
            // The strings are already randomized. No need to shuffle.
            arrays[i] = Utility.readLines(getClass(),
                    fileNames[i]).toArray(new String[0]);
        }
    }

    /**
     * Test the correctness of {@code MSD.sort(String[])}.
     */
    @Test
    public void testSort() {
        for (int i = 0; i < fileNames.length; ++i) {
            Quick3String.sort(arrays[i]);
            Assert.assertTrue("Filename: " + fileNames[i],
                    Utility.isSorted(arrays[i]));
        }
    }
}