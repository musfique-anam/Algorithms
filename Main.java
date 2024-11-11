public class Main {
    static class Graph {
        private int [][] adjMatrix;
        private String[] vertexData;
        private int size;

        public Graph (int size) {
            this.size = size;
            this.adjMatrix = new int [size][size];
            this.vertexData = new String[size];
        }
        public void addEdge (int u, int v, int weight) {
            if (u >=0 && u < size && v>=0 && v< size) {
                addMatrix[u][v] = weight;
                addMatrix[v][u] = weight;
            }
        }
        public void addVertexData (int vertex, String data) {
            if (vertex >=0 && vertex < size ) {
                vertexData[vertex] = data;
            }
        }
    }
}