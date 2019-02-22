public class MatrixGraph {
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