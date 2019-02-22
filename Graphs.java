import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Comparator;

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
        
        Dijkstra(graph, 2, 6);

        AdjListGraph graph2 = new AdjListGraph(8);
        graph2.addDirectedEdge(0, 1, 1);
        graph2.addDirectedEdge(0, 2, 2);
        graph2.addDirectedEdge(0, 3, 5);
        graph2.addDirectedEdge(1, 4, 4);
        graph2.addDirectedEdge(1, 5, 11);
        graph2.addDirectedEdge(2, 4, 9);
        graph2.addDirectedEdge(2, 5, 5);
        graph2.addDirectedEdge(2, 6, 16);
        graph2.addDirectedEdge(3, 6, 2);
        graph2.addDirectedEdge(4, 7, 18);
        graph2.addDirectedEdge(5, 7, 13);
        graph2.addDirectedEdge(6, 7, 2);

        Dijkstra(graph2, 0, 7);

        // System.out.println(graph);
    }

    //Following wiki pseudocode: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm#Description
    public static void Dijkstra(AdjListGraph graph, int source, int target) {
        final int V = graph.getV();
        int[] dist = new int[V];
        int[] prev = new int[V];

        // 6      for each vertex v in Graph:           
        // 7          if v != source
        // 8              dist[v] <- INFINITY                 // Unknown distance from source to v
        // 9          prev[v] <- UNDEFINED                    // Predecessor of v
        for (int i = 0; i < V; ++i) {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }

        //         dist[source] <- 0                           // Initialization
        dist[source] = 0;
        
        //Using edges, since they fit the criteria, I think this works? we'll see
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>(V, distComparator);
        
        // 11         Q.add_with_priority(v, dist[v])
        for (int i = 0; i < V; ++i) {
            queue.add(new Edge(i, dist[i]));
        }

        // 14     while Q is not empty:                      // The main loop
        while (!queue.isEmpty()) {
            // 15         u <- Q.extract_min()                    // Remove and return best vertex
            Edge u = queue.poll();
            //Loop break if u == target
            if (u.nodeId == target)
                break;

            // 16         for each neighbor v of u:              // only v that are still in Q
            for (Edge v : graph.adjList[u.nodeId]) {
                
                // 17             alt <- dist[u] + length(u, v) 
                int alt = dist[u.nodeId] + v.distance;

                // 18             if alt < dist[v]
                // 19                 dist[v] <- alt
                // 20                 prev[v] <- u
                // 21                 Q.decrease_priority(v, alt)
                // Since there is no decrease_priority for Java PQ
                // I am just populating queue with possible duplicate nodes
                // and breaking when the target is reached
                // unfortunately, if the target is not reachable from source, this
                // implementation will loop forever... =(
                if (alt < dist[v.nodeId]) {
                    dist[v.nodeId] = alt;
                    prev[v.nodeId] = u.nodeId;
                    queue.add(new Edge(v.nodeId, dist[v.nodeId]));
                }
            }
        }
        
        // 1  S <- empty sequence
        Stack<Integer> stack = new Stack<Integer>();

        // 2  u <- target
        int u = target;
        // 3  if prev[u] is defined or u = source:          // Do something only if the vertex is reachable
        // 4      while u is defined:                       // Construct the shortest path with a stack S
        while (u != -1) {
            // 5          insert u at the beginning of S        // Push the vertex onto the stack
            stack.add(u);
            // 6          u <- prev[u]                           // Traverse from target to source
            u = prev[u];
        }

        System.out.print("Shortest path from " + stack.peek() + " to " + target + " is: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("\nThe length is: " + dist[target]);
    }

    public static Comparator<Edge> distComparator = new Comparator<Edge>(){
		
		@Override
		public int compare(Edge e1, Edge e2) {
            return e1.distance - e2.distance;
        }
	};
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