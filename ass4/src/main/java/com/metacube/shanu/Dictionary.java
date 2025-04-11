package com.metacube.shanu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Dictionary<K extends Comparable<K>, V> implements BinarySearchTree<K, V> {

    Node<K, V> rootNode = new Node<>();

    public Dictionary(Node<K, V> node) {
        rootNode = node;
    }

    public Dictionary() {
        rootNode = null;
    }

    private boolean recursiveAdd(Node<K, V> checkNode, Node<K, V> node) {
        try {
            if (checkNode.key.compareTo(node.key) < 0 && checkNode.rightNode == null) {
                checkNode.rightNode = node;
                return true;
            } else if (checkNode.key.compareTo(node.key) > 0 && checkNode.leftNode == null) {
                checkNode.leftNode = node;
                return true;
            } else if (checkNode.equals(node)) {
                throw new AssertionError("This key already exist");
            } else {
                if (checkNode.key.compareTo(node.key) < 0) {
                    return recursiveAdd(checkNode.rightNode, node);
                } else {
                    return recursiveAdd(checkNode.leftNode, node);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean deleteNode(Node<K, V> node, Node<K, V> parentNode, K key) {
        try {

            if (node == null) {
                return false;
            }

            if (node.key.equals(key)) {
                if (node.leftNode == null && node.rightNode == null) {
                    if (parentNode.leftNode.equals(node)) {
                        parentNode.leftNode = null;
                    } else {
                        parentNode.rightNode = null;
                    }
                    return true;
                } else if (node.leftNode == null) {
                    if (parentNode.leftNode.equals(node)) {
                        parentNode.leftNode = node.rightNode;
                    } else {
                        parentNode.rightNode = node.rightNode;
                    }
                } else if (node.rightNode == null) {
                    if (parentNode.leftNode.equals(node)) {
                        parentNode.leftNode = node.leftNode;
                    } else {
                        parentNode.rightNode = node.leftNode;
                    }
                } else {
                    Node<K, V> swappNode = node.rightNode;
                    Node<K, V> swapParent = node;

                    while (swappNode.leftNode != null) {
                        swapParent = swappNode;
                        swappNode = swappNode.leftNode;
                    }
                    swapParent.leftNode = swappNode.rightNode;
                    swappNode.leftNode = node.leftNode;
                    swappNode.rightNode = node.rightNode;
                    if (parentNode != null) {
                        if (parentNode.leftNode.equals(node)) {
                            parentNode.leftNode = node.leftNode;
                        } else {
                            parentNode.rightNode = node.leftNode;
                        }
                    } else {
                        rootNode = swappNode;
                    }
                }
                return true;
            } else {
                if (node.key.compareTo(key) > 0) {
                    return deleteNode(node.leftNode, node, key);
                } else {
                    return deleteNode(node.rightNode, node, key);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void getSortedList(Node<K, V> node, List<Node<K, V>> nodeList) {
        if (node == null) {
            return;
        }

        getSortedList(node.leftNode, nodeList);
        nodeList.add(node);
        getSortedList(node.rightNode, nodeList);
    }

    private void getSortedValueList(Node<K, V> node, List<Node<K, V>> nodeList, K key1, K key2) {
        if (node == null) {
            return;
        }

        getSortedList(node.leftNode, nodeList);

        if (node.key.compareTo(key1) >= 0 && node.key.compareTo(key2) <= 0) {
            nodeList.add(node);
        }
        getSortedList(node.rightNode, nodeList);
    }

    @Override
    public boolean add(K key, V value) {
        try {
            if (rootNode == null) {
                Node<K, V> temp = new Node<>(key, value);
                rootNode = temp;
                return true;
            } else {
                Node<K, V> temp = new Node<>(key, value);
                return recursiveAdd(rootNode, temp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(K key) {
        try {
            return deleteNode(rootNode, null, key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public V get(K key) {
        Node<K, V> temp = rootNode;
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            } else if (temp.key.compareTo(key) > 0) {
                temp = temp.leftNode;
            } else {
                temp = temp.rightNode;
            }
        }

        return null;
    }

    @Override
    public List<Node<K, V>> sortedList() {
        List<Node<K, V>> result = new ArrayList<>();
        getSortedList(rootNode, result);
        return result;
    }

    @Override
    public List<Node<K, V>> sortedList(K key1, K key2) {
        List<Node<K, V>> result = new ArrayList<>();
        getSortedValueList(rootNode, result, key1, key2);
        return result;
    }

    public static Dictionary<String, String> createDictionary(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Dictionary<String, String> myDict = new Dictionary<>();

        JsonNode node = objectMapper.readTree(file);
        List<String> keys = new ArrayList<>();
        Iterator<String> it = node.fieldNames();

        it.forEachRemaining(e -> keys.add(e));

        for (String key : keys) {
            String value = node.get(key).asText();
            myDict.add(key, value);
        }

        return myDict;
    }
}
