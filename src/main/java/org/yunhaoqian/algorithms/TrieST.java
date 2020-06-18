package org.yunhaoqian.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class TrieST<Value> {
    // Alphabet size.
    private static final int R = 256;
    private Node root;

    private static class Node {
        // If val is of type Value, then Node must not be static.
        // If Node is non-static, then Node must be a generic type.
        // However, Java does not support array of generics.
        private Object val;
        private Node[] next = new Node[R];
    }

    /**
     * Given a string key, return its corresponding value.
     *
     * @param key The string key.
     * @return The value that corresponds to {@code key}, or {@code null} if the
     * key is not in the table.
     */
    public Value get(String key) {
        Node x = getNode(key);
        // No need for type checking since x.val is given by put(String) method.
        return x == null ? null : (Value) x.val;
    }

    /**
     * Given a string key, return its corresponding node.
     *
     * @param key The string key.
     * @return Its corresponding node, or {@code null} if the key is not in the
     * table.
     */
    private Node getNode(String key) {
        Node x = root;
        for (int i = 0; i < key.length(); ++i) {
            if (x == null)
                return null;
            x = x.next[key.charAt(i)];
        }
        return x;
    }

    /**
     * Insert, delete or update a key-value pair.
     * 1. Delete the key from the table if {@code val = null}.
     * 2. Update the key with the new value if {@code key} is already in the
     * table.
     * 3. Insert the key-value pair if the key is not currently in the table.
     *
     * @param key The key.
     * @param val Value that corresponds to the key. Set it to {@code null} if
     *            the key is to be deleted.
     */
    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    /**
     * Insert, delete or update a key-value pair from a node.
     *
     * @param x   The current node.
     * @param key The key.
     * @param val Value that corresponds to the key.
     * @param d   Node {@code x} corresponds to the ({@code d} - 1)'s digit of
     *            {@code val}.
     * @return The same node as {@code x} if {@code x} exists, or a newly
     * created one if {@code x = null}.
     */
    private Node put(Node x, String key, Value val, int d) {
        if (x == null)
            return new Node();
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    /**
     * Find all keys in the table. Equivalent to {@code keysWithPrefix("")}.
     *
     * @return An iterator that contains all the keys in the table.
     */
    public Iterable<String> keys() {
        Queue<String> q = new LinkedList<>();
        if (root != null)
            collect(root, "", q);
        return q;
    }

    /**
     * Find all keys in the table with a given prefix.
     *
     * @param pre The prefix.
     * @return An iterator of strings that contains all the keys with prefix
     * {@code pre}.
     */
    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new LinkedList<>();
        Node x = getNode(pre);
        if (x != null)
            collect(x, pre, q);
        return q;
    }

    /**
     * Among the children of a given node, find all the keys with a given
     * prefix.
     *
     * @param x   The node where the search begins.
     * @param pre The prefix.
     * @param q   The found keys will be appended to the end of {@code q}.
     */
    private void collect(Node x, String pre, Queue<String> q) {
        if (x.val != null)
            q.add(pre);
        for (char c = 0; c < R; ++c)
            if (x.next[c] != null)
                collect(x.next[c], pre + c, q);
    }
}