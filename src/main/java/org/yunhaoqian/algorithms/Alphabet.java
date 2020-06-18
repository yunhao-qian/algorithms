package org.yunhaoqian.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Alphabet {
    // Character.MAX_VALUE seems unavailable.
    private static final int CHAR_MAX = 65536;

    private int[] charToIndex;
    private char[] indexToChar;

    public static final Alphabet BINARY = new Alphabet("01");
    public static final Alphabet DNA = new Alphabet("ACTG");
    public static final Alphabet OCTAL = new Alphabet("01234567");
    public static final Alphabet DECIMAL = new Alphabet("0123456789");
    public static final Alphabet HEXADECIMAL = new Alphabet("0123456789ABCDEF");
    public static final Alphabet PROTEIN = new Alphabet("ACDEFGHIKLMNPQRSTVWY");
    public static final Alphabet LOWERCASE = new Alphabet(
            "abcdefghijklmnopqrstuvwxyz");
    public static final Alphabet UPPERCASE = new Alphabet(
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    public static final Alphabet BASE64 = new Alphabet(
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    /**
     * Construct a new {@code Alphabet} object from the characters in {@code s}.
     *
     * @param s Any string. The characters in the string will be used to
     *          construct the Alphabet. Repeated characters in the string will
     *          share the same index.
     */
    public Alphabet(String s) {
        int r = 0;
        charToIndex = new int[CHAR_MAX];
        Arrays.fill(charToIndex, -1);
        List<Character> charList = new LinkedList<>();
        for (char c : s.toCharArray()) {
            // Skip repeated characters.
            if (charToIndex[c] >= 0)
                continue;
            charToIndex[c] = r++;
            charList.add(c);
        }
        indexToChar = new char[charList.size()];
        int i = 0;
        for (char c : charList) {
            indexToChar[i++] = c;
        }
    }

    /**
     * Get the character at a given index. The provided character must be in the
     * alphabet. Otherwise, an exception will be thrown.
     *
     * @param index The index.
     * @return The character at {@code index}.
     */
    public char toChar(int index) {
        return indexToChar[index];
    }

    /**
     * Get the index of a given character. Return {@code -1} if the character is
     * not in the alphabet.
     *
     * @param c The character.
     * @return The index of {@code c}, or {@code -1} if it is not in the
     * alphabet.
     */
    public int toIndex(char c) {
        return charToIndex[c];
    }

    /**
     * Checker whether a character is in the alphabet.
     *
     * @param c The character.
     * @return {@code true} if {@code c} is in the alphabet; {@code false}
     * otherwise.
     */
    public boolean contains(char c) {
        return charToIndex[c] >= 0;
    }

    /**
     * Get the size of the alphabet.
     *
     * @return The number of elements in the alphabet.
     */
    public int R() {
        return indexToChar.length;
    }

    /**
     * Get the size required to store an index of the alphabet.
     *
     * @return The number of bits required to store an index.
     */
    public int lgR() {
        int lg = 0;
        for (int r = R() - 1; r > 0; r >>= 1) {
            ++lg;
        }
        return lg;
    }

    /**
     * Convert a string to its corresponding index array.
     *
     * @param s The string.
     * @return Array of character indices.
     */
    public int[] toIndices(String s) {
        int[] indices = new int[s.length()];
        for (int i = 0; i < s.length(); ++i)
            indices[i] = toIndex(s.charAt(i));
        return indices;
    }

    /**
     * Convert an index array to its corresponding string.
     *
     * @param indices The index array.
     * @return String that consists of characters with corresponding indices.
     */
    String toChars(int[] indices) {
        char[] chars = new char[indices.length];
        for (int i = 0; i < indices.length; ++i)
            chars[i] = toChar(indices[i]);
        return new String(chars);
    }
}