package org.yunhaoqian.algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class MSDTest {
    private static String[] fileNames = new String[] {
            "1000words.txt",
            "commonwords.txt",
            "ospd.txt",
            "wordlist.txt",
            "words.shakespeare.txt",
            "words.txt",
            "words5-knuth.txt"
    };

    private String[][] arrays;

    /**
     * Initialize the array of shuffled string arrays. They hold the lines from files whose names are from {@fileNames}.
     *
     * @throws Exception
     */
    @Before
    public void initArrays() throws Exception {
        arrays = new String[fileNames.length][];
        for (int i = 0; i < fileNames.length; ++i) {
            List<String> list = Utility.readLines(getClass(), fileNames[i]);
            Collections.shuffle(list);
            arrays[i] = list.toArray(new String[0]);
        }
    }

    /**
     * Test the correctness of {@code MSD.sort(String[])}.
     */
    @Test
    public void testSort() {
        for (int i = 0; i < fileNames.length; ++i) {
            MSD.sort(arrays[i]);
            Assert.assertTrue("Filename: " + fileNames[i], Utility.isSorted(arrays[i]));
        }
    }
}