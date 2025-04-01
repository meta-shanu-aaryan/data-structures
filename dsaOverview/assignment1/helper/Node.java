package dsaOverview.assignment1.helper;

public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public boolean setValue(int num) {
        try {
            this.value = num;
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean setNext(Node node) {
        try {
            this.next = node;
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
