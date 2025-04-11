package AlgorithmanalysisAndDesign1.assignment2;

public class Node<T extends Comparable<T>> {
    T value;
    Node<T> prev;
    Node<T> next;

    public Node(T value, Node<T> prev) {
        this.value = value;
        this.prev = prev;
    }

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrev() {
        return prev;
    }
}
