import java.util.*;

public class BFS {
    
    static void bfs(int[][] adjMatrix, int s) {
        int V = adjMatrix.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int curr = q.poll();
            //System.out.print(curr + " ");
            System.out.print((char) (curr + 'A') + " ");
            
            for (int v = 0; v < V; v++) {
                // Check if there's an edge and the node hasn't been visited
                if (adjMatrix[curr][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    q.add(v);//adjacency is 'v',so add it
                }
            }
        }
    }
    
    static void addEdge(int[][] adjMatrix, int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] adjMatrix = new int[V][V];

        addEdge(adjMatrix, 0, 1);
        addEdge(adjMatrix, 0, 2);
        addEdge(adjMatrix, 1, 3);
        addEdge(adjMatrix, 1, 4);
        addEdge(adjMatrix, 2, 4);

        //System.out.println("BFS starting from 0:");
        System.out.println("BFS starting from vertex A:");
        bfs(adjMatrix, 0);
    }
}
