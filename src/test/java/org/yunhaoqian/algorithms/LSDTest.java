package org.yunhaoqian.algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class LSDTest {
    String[] array;

    /**
     * Initialize the shuffled string array.
     *
     * @throws Exception
     */
    @Before
    public void initArray() throws Exception {
        List<String> list = Utility.readLines(getClass(), "words5-knuth.txt");
        Collections.shuffle(list);
        array = list.toArray(new String[0]);
    }

    /**
     * Check whether the strings in {@code array} have the same length.
     *
     * @return {@code true} if they are of the same length; {@code false} otherwise.
     */
    private boolean haveSameLength() {
        int W = array[0].length();
        for (int i = 1; i < array.length; ++i)
            if (array[i].length() != W)
                return false;
        return true;
    }

    /**
     * Test the correctness of {@code LSD.sort(String[], int)}.
     */
    @Test
    public void testSort() {
        Assert.assertTrue(array.length > 0);
        Assert.assertTrue(haveSameLength());
        LSD.sort(array, array[0].length());
        Assert.assertTrue(Utility.isSorted(array));
    }
}