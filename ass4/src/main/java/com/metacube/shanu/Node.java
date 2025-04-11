package com.metacube.shanu;

public class Node<K extends Comparable<K>, V> {
    K key;
    V value;
    Node<K, V> leftNode;
    Node<K, V> rightNode;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        leftNode = null;
        rightNode = null;
    }

    public Node() {

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node<K, V> other = (Node<K, V>) obj;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        return true;
    }

}
