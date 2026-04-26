import java.util.*;

public class Graph {
    private Map<String, List<Edge>> adjacencyList;
    private List<Edge> edges;

    public Graph() {
        adjacencyList = new HashMap<>();
        edges = new ArrayList<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String source, String destination, int weight) {
        addVertex(source);
        addVertex(destination);

        Edge edge = new Edge(source, destination, weight);
        edges.add(edge);

        adjacencyList.get(source).add(edge);
        adjacencyList.get(destination).add(new Edge(destination, source, weight));
    }

    public void printGraph() {
        for (String vertex : adjacencyList.keySet()) {
            System.out.print(vertex + " -> ");

            List<Edge> neighbors = adjacencyList.get(vertex);
            for (Edge edge : neighbors) {
                System.out.print("(" + edge.getDestination() + ", " + edge.getWeight() + ") ");
            }

            System.out.println();
        }
    }

    public PathResult dijkstra(String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (String vertex : adjacencyList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
            previous.put(vertex, null);
        }

        distances.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            String current = pq.poll();

            if (current.equals(end)) {
                break;
            }

            for (Edge edge : adjacencyList.get(current)) {
                String neighbor = edge.getDestination();
                int newDistance = distances.get(current) + edge.getWeight();

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    previous.put(neighbor, current);

                    pq.remove(neighbor);
                    pq.add(neighbor);
                }
            }
        }

        List<String> path = new ArrayList<>();
        String current = end;

        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }

        Collections.reverse(path);

        return new PathResult(path, distances.get(end));
    }

    public List<Edge> kruskalMST() {
        List<Edge> mst = new ArrayList<>();
        List<Edge> sortedEdges = new ArrayList<>(edges);

        sortedEdges.sort(Comparator.comparingInt(Edge::getWeight));

        DisjointSet disjointSet = new DisjointSet();

        for (String vertex : adjacencyList.keySet()) {
            disjointSet.makeSet(vertex);
        }

        for (Edge edge : sortedEdges) {
            String sourceRoot = disjointSet.find(edge.getSource());
            String destinationRoot = disjointSet.find(edge.getDestination());

            if (!sourceRoot.equals(destinationRoot)) {
                mst.add(edge);
                disjointSet.union(edge.getSource(), edge.getDestination());
            }
        }

        return mst;
    }
}