import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Comparator;

public class AdjListGraph {
    private int v;
    LinkedList<Edge>[] adjList;

    public AdjListGraph(int v) {
        this.v = v;
        adjList = new LinkedList[v];

        for (int i = 0; i < adjList.length; ++i) {
            adjList[i] = new LinkedList<Edge>();
        }
    }

    public void addEdge(int start, int end) {
        adjList[start].add(new Edge(end, 1));
        adjList[end].add(new Edge(start, 1));
    }
    public void addEdge(int start, int end, int distance) {
        adjList[start].add(new Edge(end, distance));
        adjList[end].add(new Edge(start, distance));
    }

    public void addDirectedEdge(int start, int end) {
        adjList[start].add(new Edge(end, 1));
    }
    
    public void addDirectedEdge(int start, int end, int distance) {
        adjList[start].add(new Edge(end, distance));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Adj List Version: \n");
        for (int i = 0; i < adjList.length; ++i) {
            sb.append(i);
            for (Edge item : adjList[i]) {
                sb.append(" -> " + item.nodeId);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * @return the v
     */
    public int getV() {
        return v;
    }

}