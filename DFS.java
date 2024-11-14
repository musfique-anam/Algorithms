class DFS {
    static int V = 4; 
    private final int[][] adjMatrix;
    private final boolean[] visited;

    DFS(int vertices) {
        adjMatrix = new int[vertices][vertices];
        visited = new boolean[vertices];
    }

    void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1; 
    }

    // Recursive DFS function
    void DFSMain(int vertex) {
        visited[vertex] = true;

        //System.out.print(vertex + " ");
        System.out.print((char)(vertex + 'A') + " "); 

        for (int i = 0; i < V; i++) {
            if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                DFSMain(i);
            }
        }
    }

    public static void main(String[] args) {
        DFS g = new DFS(V);

        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 3); 

        System.out.println("Following is Depth First Traversal starting from vertex C:");
        g.DFSMain(2); 
    }
}
