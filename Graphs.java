import java.util.LinkedList;

public class Graphs {
    
    public static void main(String[] args) {
        AdjListGraph graph = new AdjListGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        
        MatrixGraph mGraph = new MatrixGraph(5);
        mGraph.addEdge(0, 1);
        mGraph.addEdge(0, 4);
        mGraph.addEdge(1, 2);
        mGraph.addEdge(1, 3);
        mGraph.addEdge(1, 4);
        mGraph.addEdge(2, 3);
        mGraph.addEdge(3, 4);
        
        System.out.println(graph);
        System.out.println();
        System.out.println(mGraph);
    }
}

class AdjListGraph {
    private int v;
    LinkedList<Integer>[] adjList;

    public AdjListGraph(int v) {
        this.v = v;
        adjList = new LinkedList[v];

        for (int i = 0; i < adjList.length; ++i) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int start, int end) {
        adjList[start].add(end);
        adjList[end].add(start);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Adj List Version: \n");
        for (int i = 0; i < adjList.length; ++i) {
            sb.append(i);
            for (Integer item : adjList[i]) {
                sb.append(" -> " + item);
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