package com.metacube.shanu;

import java.util.List;

public interface BinarySearchTree<K extends Comparable<K>, V> {
    public boolean add(K key, V value);

    public boolean delete(K key);

    public V get(K key);

    public List<Node<K, V>> sortedList();

    public List<Node<K, V>> sortedList(K key1, K key2);
}
