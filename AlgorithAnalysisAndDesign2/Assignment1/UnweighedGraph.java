package AlgorithAnalysisAndDesign2.Assignment1;

public interface UnweighedGraph<T> {
    public boolean isConnected();

    public boolean reachable(Vertex<T> source);

}
