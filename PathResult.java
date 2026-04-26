import java.util.*;

public class PathResult {
    private List<String> path;
    private int distance;

    public PathResult(List<String> path, int distance) {
        this.path = path;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Path: " + String.join(" -> ", path) + "\nTotal Weight: " + distance;
    }
}