package TreesAndGraphs.Assignment1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private T data;
    private Node<T> parent;
    private List<Node<T>> children;
    private String date;
    private String time;

    /**
     * Gets the data of the node contains
     * 
     * @return data of generic type / the type it has
     */
    public T getData() {
        return data;
    }

    /**
     * Gets parent node of node it is called with.
     * 
     * @return parent node of current node
     */
    public Node<T> getParent() {
        return parent;
    }

    /**
     * Gets the list of Children node of the node it is called with
     * 
     * @return List of Nodes that are children
     */
    public List<Node<T>> getChildren() {
        return children;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * Gets the time when the node was created
     * 
     * @return String time in HH:MM:SS format
     */
    public String getTIme() {
        return this.time;
    }

    /**
     * Gets the date when the node was created
     * 
     * @return String date in YYYY-MM-DD format
     */
    public String getDate() {
        return this.date;
    }

    public Node(T data, Node<T> parent, List<Node<T>> children) {
        this.data = data;
        this.parent = parent;
        this.children = children;
        this.date = LocalDate.now().toString();
        this.time = LocalTime.now().toString();
    }

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
        // if (parent != null) {
        // parent.children.add(this);
        // }
        this.children = new ArrayList<>();
        this.date = LocalDate.now().toString();
        this.time = LocalTime.now().toString().substring(0, 8);
    }

    /**
     * Takes the node and add it to the list of node it is called with that is tree
     * 
     * @param childNode node to add
     * @return true if added successfully
     */
    public boolean addNode(Node<T> childNode) {
        return this.children.add(childNode);
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }
}
