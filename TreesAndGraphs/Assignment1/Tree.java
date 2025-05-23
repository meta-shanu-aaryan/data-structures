package TreesAndGraphs.Assignment1;

import java.util.ArrayList;

public class Tree<T> {
    private Node<T> root;

    public Tree(Node<T> root, T data) {
        this.root = root;
        root.setData(data);
        root.setChildren(new ArrayList<>());
    }

    public Tree(T data) {
        root = new Node<T>(data, null);
    }

    /**
     * Gets the root node of the tree
     * 
     * @return root node
     */
    public Node<T> getRoot() {
        return root;
    }

}
