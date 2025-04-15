package AlgorithAnalysisAndDesign2.Assignment1;

public class Edge<T> {
    private Vertex<T> to;
    private int weight;

    public Edge(Vertex<T> destination, int weight) {
        this.to = destination;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex<T> getDestination() {
        return to;
    }

    public void setDestination(Vertex<T> destination) {
        this.to = destination;
    }
}
