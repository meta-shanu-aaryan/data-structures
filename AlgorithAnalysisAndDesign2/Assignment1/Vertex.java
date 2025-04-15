package AlgorithAnalysisAndDesign2.Assignment1;

import java.util.HashMap;
import java.util.Map;

public class Vertex<T> {
    T data;
    Map<Vertex<T>, Integer> connectedNode = new HashMap<>();

    public Vertex(T data) {
        this.data = data;
    }

    public boolean addConnectedNode(Vertex<T> childNode, int weight) {
        connectedNode.putIfAbsent(childNode, weight);
        if (connectedNode.containsKey(childNode)) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        Vertex<T> obj2 = (Vertex<T>) obj;
        return data.equals(obj2.data);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}