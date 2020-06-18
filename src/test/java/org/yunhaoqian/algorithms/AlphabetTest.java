package org.yunhaoqian.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class AlphabetTest {
    /**
     * Test the correctness of {@code Alphabet.contains(char)}.
     */
    @Test
    public void testContains() {
        Assert.assertTrue(Alphabet.BINARY.contains('0'));
        Assert.assertFalse(Alphabet.DNA.contains('D'));
        Assert.assertTrue(Alphabet.OCTAL.contains('5'));
        Assert.assertFalse(Alphabet.DECIMAL.contains('x'));
        Assert.assertTrue(Alphabet.HEXADECIMAL.contains('E'));
        Assert.assertFalse(Alphabet.PROTEIN.contains('Z'));
        Assert.assertTrue(Alphabet.LOWERCASE.contains('w'));
        Assert.assertFalse(Alphabet.UPPERCASE.contains('前'));
        Assert.assertTrue(Alphabet.BASE64.contains('+'));
    }

    /**
     * Test the correctness of {@code Alphabet.R()}.
     */
    @Test
    public void testR() {
        Assert.assertEquals(2, Alphabet.BINARY.R());
        Assert.assertEquals(4, Alphabet.DNA.R());
        Assert.assertEquals(8, Alphabet.OCTAL.R());
        Assert.assertEquals(10, Alphabet.DECIMAL.R());
        Assert.assertEquals(16, Alphabet.HEXADECIMAL.R());
        Assert.assertEquals(20, Alphabet.PROTEIN.R());
        Assert.assertEquals(26, Alphabet.LOWERCASE.R());
        Assert.assertEquals(26, Alphabet.UPPERCASE.R());
        Assert.assertEquals(64, Alphabet.BASE64.R());
    }

    /**
     * Test the correctness of {@code Alphabet.R()}.
     */
    @Test
    public void testLgR() {
        Assert.assertEquals(1, Alphabet.BINARY.lgR());
        Assert.assertEquals(2, Alphabet.DNA.lgR());
        Assert.assertEquals(3, Alphabet.OCTAL.lgR());
        Assert.assertEquals(4, Alphabet.DECIMAL.lgR());
        Assert.assertEquals(4, Alphabet.HEXADECIMAL.lgR());
        Assert.assertEquals(5, Alphabet.PROTEIN.lgR());
        Assert.assertEquals(5, Alphabet.LOWERCASE.lgR());
        Assert.assertEquals(5, Alphabet.UPPERCASE.lgR());
        Assert.assertEquals(6, Alphabet.BASE64.lgR());
    }

    /**
     * Test the correctness of {@code Alphabet.toIndices(String)}, which
     * indirectly tests {@code Alphabet.toIndex(char)}.
     */
    @Test
    public void testToIndices() {
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 3, 2, 1, 0, 2, 2, 0},
                Alphabet.DNA.toIndices("ACTGGTCATTA"));
        Assert.assertArrayEquals(new int[]{3, 1, 1, 1, 4, 1, 3, 7},
                Alphabet.OCTAL.toIndices("31114137"));
        Assert.assertArrayEquals(
                new int[]{13, 0, 13, 9, 8, 13, 6, 24, 20, 13, 7, 0, 14},
                Alphabet.LOWERCASE.toIndices("nanjingyunhao"));
        Assert.assertArrayEquals(new int[]{2, 33, 34, 39, 26, 62, 53},
                Alphabet.BASE64.toIndices("China+1"));
    }

    /**
     * Test the correctness of {@code Alphabet.toChars(int[])}, which indirectly
     * tests {@code Alphabet.toChar(int)}.
     */
    @Test
    public void testToChars() {
        Assert.assertEquals("ACTGGTCATTA", Alphabet.DNA.toChars(
                new int[]{0, 1, 2, 3, 3, 2, 1, 0, 2, 2, 0}));
        Assert.assertEquals("31114137", Alphabet.OCTAL.toChars(
                new int[]{3, 1, 1, 1, 4, 1, 3, 7}));
        Assert.assertEquals("nanjingyunhao", Alphabet.LOWERCASE.toChars(
                new int[]{13, 0, 13, 9, 8, 13, 6, 24, 20, 13, 7, 0, 14}));
        Assert.assertEquals("China+1", Alphabet.BASE64.toChars(
                new int[]{2, 33, 34, 39, 26, 62, 53}));
    }
}