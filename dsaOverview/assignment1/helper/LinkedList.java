package dsaOverview.assignment1.helper;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList(int value) {
        Node temp = new Node(value);
        this.head = temp;
        this.tail = temp;
        size++;
    }

    public boolean append(int value) {
        Node temp = new Node(value);
        this.tail.next = temp;
        this.tail = temp;
        // size++;
        return true;
    }

    public boolean append(Node node) {
        this.tail.next = node;
        this.tail = node;
        return true;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public int getSize() {
        return size;
    }
}