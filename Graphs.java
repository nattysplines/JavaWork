import java.util.LinkedList;

public class Graphs {
    
    public static void main(String[] args) {

        /*
        *   Graph represented by below edges.
        *   1--0  7--6
        *   |  | /| /|
        *   |  |/ |/ |
        *   2  3--4--5
        */

        AdjListGraph graph = new AdjListGraph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 7);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        
        System.out.println(graph);
    }
}

class Edge {
    int nodeId;
    int distance;

    public Edge(int nodeId, int distance) {
        this.nodeId = nodeId;
        this.distance = distance;
    }
}

class AdjListGraph {
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

class MatrixGraph {
    private int v;
    int[][] matrix;

    public MatrixGraph(int v) {
        this.v = v;
        matrix = new int[v][v];
    }

    public void addEdge(int start, int end) {
        matrix[start][end] = 1;
        matrix[end][start] = 1;
    }

    public void addEdge(int start, int end, int distance) {
        matrix[start][end] = distance;
        matrix[end][start] = distance;
    }

    /**
     * @return the v
     */
    public int getV() {
        return v;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrix version: \n");
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                sb.append(matrix[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}