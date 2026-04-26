import java.util.*;

public class DisjointSet {
    private Map<String, String> parent;

    public DisjointSet() {
        parent = new HashMap<>();
    }

    public void makeSet(String vertex) {
        parent.put(vertex, vertex);
    }

    public String find(String vertex) {
        if (!parent.get(vertex).equals(vertex)) {
            parent.put(vertex, find(parent.get(vertex)));
        }

        return parent.get(vertex);
    }

    public void union(String vertex1, String vertex2) {
        String root1 = find(vertex1);
        String root2 = find(vertex2);

        if (!root1.equals(root2)) {
            parent.put(root1, root2);
        }
    }
}