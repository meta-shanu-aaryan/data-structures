package AlgorithAnalysisAndDesign2.Assignment1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();

        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.addNode(7);

        graph.addEdge(graph.getVertexByData(1), graph.getVertexByData(2), 3);
        graph.addEdge(graph.getVertexByData(1), graph.getVertexByData(3), 6);
        graph.addEdge(graph.getVertexByData(1), graph.getVertexByData(4), 2);
        graph.addEdge(graph.getVertexByData(2), graph.getVertexByData(3), 4);
        graph.addEdge(graph.getVertexByData(3), graph.getVertexByData(5), 5);
        graph.addEdge(graph.getVertexByData(4), graph.getVertexByData(5), 2);
        graph.addEdge(graph.getVertexByData(6), graph.getVertexByData(7), 1);

        System.out.println("Is Connected: " + graph.isConnected());

        System.out.println("Is Reachable " + graph.reachable(graph.getVertexByData(5)));

        for (String edge : graph.mst()) {
            System.out.println(edge);
        }

        Vertex<Integer> start = graph.getVertexByData(2);
        Vertex<Integer> end = graph.getVertexByData(5);

        List<Integer> path = graph.shortestPath(start, end);

        System.out.println("Flow will be");
        for (Integer i : path) {
            System.out.print(i + " -> ");
        }
    }
}