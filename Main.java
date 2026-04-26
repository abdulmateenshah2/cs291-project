import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph campus = new Graph();

        // UMKC campus locations
        campus.addVertex("Student Union");
        campus.addVertex("Bloch School");
        campus.addVertex("Miller Nichols Library");
        campus.addVertex("Spencer Chemistry");
        campus.addVertex("Flarsheim Hall");
        campus.addVertex("Katz Hall");
        campus.addVertex("Swinney Rec Center");
        campus.addVertex("Royall Hall");
        campus.addVertex("Haag Hall");
        campus.addVertex("Education Building");

        // Weighted edges represent approximate walking distance/time between locations
        campus.addEdge("Student Union", "Bloch School", 2);
        campus.addEdge("Student Union", "Miller Nichols Library", 3);
        campus.addEdge("Student Union", "Spencer Chemistry", 4);
        campus.addEdge("Bloch School", "Miller Nichols Library", 3);
        campus.addEdge("Miller Nichols Library", "Spencer Chemistry", 2);
        campus.addEdge("Spencer Chemistry", "Flarsheim Hall", 2);
        campus.addEdge("Flarsheim Hall", "Katz Hall", 3);
        campus.addEdge("Katz Hall", "Swinney Rec Center", 4);
        campus.addEdge("Swinney Rec Center", "Royall Hall", 5);
        campus.addEdge("Royall Hall", "Haag Hall", 2);
        campus.addEdge("Haag Hall", "Education Building", 3);
        campus.addEdge("Education Building", "Student Union", 5);
        campus.addEdge("Miller Nichols Library", "Royall Hall", 4);
        campus.addEdge("Spencer Chemistry", "Haag Hall", 3);
        campus.addEdge("Bloch School", "Education Building", 4);

        System.out.println("UMKC Campus Weighted Graph");
        System.out.println("--------------------------");
        campus.printGraph();

        System.out.println("\nShortest Path Example using Dijkstra's Algorithm");
        System.out.println("From Student Union to Katz Hall:");
        PathResult shortestPath = campus.dijkstra("Student Union", "Katz Hall");
        System.out.println(shortestPath);

        System.out.println("\nMinimum Spanning Tree using Kruskal's Algorithm");
        List<Edge> mst = campus.kruskalMST();

        int totalWeight = 0;
        for (Edge edge : mst) {
            System.out.println(edge);
            totalWeight += edge.getWeight();
        }

        System.out.println("Total MST Weight: " + totalWeight);
    }
}