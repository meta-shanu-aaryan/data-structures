package AlgorithmanalysisAndDesign1.assignment2;

public class LinkedList<T extends Comparable<T>> {
    Node<T> head;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public LinkedList(T value) {
        this.head = new Node(value, null);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public boolean add(T value) {
        try {
            Node<T> tempPrev = null;
            Node<T> temp = head;
            while (temp.next != null) {
                tempPrev = temp;
                temp = temp.next;
            }
            temp.next = new Node(value, tempPrev);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Node<T> sort() {
        try {
            @SuppressWarnings({ "rawtypes", "unchecked" })
            Node<T> dummy = new Node(null);
            Node<T> current = head;
            while (current != null) {
                Node<T> prev = dummy;
                Node<T> nextNode = current.getNext();
                while (prev.getNext() != null && prev.getNext().getValue().compareTo(current.getValue()) > 0) {
                    prev = prev.getNext();
                }
                current.next = prev.next;
                prev.next = current;
                current = nextNode;
            }
            return dummy.getNext();
        } catch (Exception e) {
            throw new Error("Error in sorting the linked list!");
        }
    }
}
