package AlgorithAnalysisAndDesign2.Assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph<T> implements UnweighedGraph<T> {

    private List<Vertex<T>> vertexList = new ArrayList<>();

    public List<Vertex<T>> getVertexList() {
        return vertexList;
    }

    public void printGraph() {
        for (Vertex<T> node : vertexList) {
            System.out.println("For " + node.data);
            for (var v : node.connectedNode.entrySet()) {
                System.out.println(v.getKey().data + " " + v.getValue());
            }
        }
    }

    public boolean addNode(T data) {
        if (vertexList.contains(new Vertex<T>(data))) {
            throw new AssertionError("This node already exist");
        } else {
            return vertexList.add(new Vertex<T>(data));
        }
    }

    public boolean addEdge(Vertex<T> v1, Vertex<T> v2, int weight) {
        for (Vertex<T> v : vertexList) {
            if (v.equals(v1)) {
                v.addConnectedNode(v2, weight);
                break;
            }
        }

        for (Vertex<T> v : vertexList) {
            if (v.equals(v2)) {
                v.addConnectedNode(v1, weight);
                break;
            }
        }

        return true;
    }

    private void connected(Vertex<T> currNode, Map<Vertex<T>, Boolean> visited) {
        visited.put(currNode, true);

        for (Map.Entry<Vertex<T>, Integer> mp : currNode.connectedNode.entrySet()) {
            Vertex<T> neighbor = mp.getKey();
            if (!visited.containsKey(neighbor)) {
                connected(neighbor, visited);
            }
        }
    }

    @Override
    public boolean isConnected() {
        if (vertexList.isEmpty()) {
            return true;
        }

        Map<Vertex<T>, Boolean> visited = new HashMap<>();
        connected(vertexList.get(0), visited);

        return visited.size() == vertexList.size();
    }

    @Override
    public boolean reachable(Vertex<T> source) {
        if (vertexList.isEmpty()) {
            return true;
        }

        Map<Vertex<T>, Boolean> visited = new HashMap<>();
        connected(source, visited);

        return visited.size() == vertexList.size();
    }

    public Vertex<T> getVertexByData(T data) {
        for (Vertex<T> v : vertexList) {
            if (v.data.equals(data)) {
                return v;
            }
        }
        return null;
    }

    private class MSTEdge {
        Vertex<T> from;
        Vertex<T> to;
        int weight;

        MSTEdge(Vertex<T> from, Vertex<T> to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public List<String> mst() {
        List<String> result = new ArrayList<>();
        Set<Vertex<T>> visited = new HashSet<>();
        PriorityQueue<MSTEdge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        if (vertexList.isEmpty())
            return result;

        Vertex<T> start = vertexList.get(0);
        visited.add(start);

        for (var entry : start.connectedNode.entrySet()) {
            pq.offer(new MSTEdge(start, entry.getKey(), entry.getValue()));
        }

        while (!pq.isEmpty() && visited.size() < vertexList.size()) {
            MSTEdge edge = pq.poll();

            if (visited.contains(edge.to))
                continue;

            visited.add(edge.to);
            result.add(edge.from + " - " + edge.to + " : " + edge.weight);

            for (var entry : edge.to.connectedNode.entrySet()) {
                if (!visited.contains(entry.getKey())) {
                    pq.offer(new MSTEdge(edge.to, entry.getKey(), entry.getValue()));
                }
            }
        }

        return result;
    }

    public List<T> shortestPath(Vertex<T> start, Vertex<T> end) {
        Map<Vertex<T>, Integer> distance = new HashMap<>();
        Map<Vertex<T>, Vertex<T>> previous = new HashMap<>();
        PriorityQueue<Vertex<T>> pq = new PriorityQueue<>(Comparator.comparingInt(distance::get));
    
        for (Vertex<T> v : vertexList) {
            distance.put(v, Integer.MAX_VALUE);
        }
    
        distance.put(start, 0);
        pq.offer(start);
    
        while (!pq.isEmpty()) {
            Vertex<T> current = pq.poll();
    
            if (current.equals(end)) break;
    
            for (Map.Entry<Vertex<T>, Integer> neighborEntry : current.connectedNode.entrySet()) {
                Vertex<T> neighbor = neighborEntry.getKey();
                int weight = neighborEntry.getValue();
    
                int newDist = distance.get(current) + weight;
                if (newDist < distance.get(neighbor)) {
                    distance.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    pq.remove(neighbor); // Ensure no duplicates
                    pq.offer(neighbor);
                }
            }
        }
    
        // Reconstruct path
        List<T> path = new ArrayList<>();
        Vertex<T> step = end;
        if (!previous.containsKey(end) && !start.equals(end)) return path; // No path
    
        while (step != null) {
            path.add(0, step.data);
            step = previous.get(step);
        }
    
        return path;
    }
}
