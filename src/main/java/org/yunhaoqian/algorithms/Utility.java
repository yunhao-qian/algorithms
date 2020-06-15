package org.yunhaoqian.algorithms;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Utility {
    /**
     * Swap two elements in an array.
     *
     * @param array  The array.
     * @param index1 Index of the first element.
     * @param index2 Index of the second element.
     * @param <T>    Any type.
     */
    public static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * Extract lines of a text file from a class directory.
     *
     * @param fileName  Name of the text file.
     * @param fromClass Class from which to search for the file.
     * @return A string list that holds the lines.
     * @throws Exception
     */
    public static List<String> readLines(Class fromClass, String fileName)
            throws Exception {
        URL url = fromClass.getResource(fileName);
        if (url == null)
            throw new RuntimeException("File not found");
        return Files.readAllLines(Paths.get(url.toURI()));
    }

    /**
     * Return whether an array is sorted in increasing order.
     *
     * @param array Array to be checked.
     * @param <T>   Class that implements {@code Comparable}.
     * @return {@code true} if {@code array} is sorted; {@code false} otherwise.
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 1; i < array.length; ++i)
            if (array[i].compareTo(array[i - 1]) < 0)
                return false;
        return true;
    }
}