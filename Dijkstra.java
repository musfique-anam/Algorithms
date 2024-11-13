import java.util.Arrays;

public class Dijkstra {

    private static final  int INF=Integer.MAX_VALUE;

    private static int minDistance (int [] dist,boolean [] sptSet,int V) {
        int min =INF, minIndex =-1;
        for(int v=0;v<V;v++) {
            if(!sptSet[v] && dist[v]<=min) {
                min = dist[v];
                minIndex =v;
            }
        }
        return minIndex;
    }

    public static void dijkstra (int[][]graph,int source) {
        int V = graph.length;
        int[] dist =new int [V];
        boolean[] sptSet =new boolean[V];

        Arrays.fill(dist, INF);
        dist[source] = 0;

        for (int count =0; count < V-1;count++){
            int u =minDistance(dist,sptSet,V);
            sptSet[u] =true;

            for(int v=0;v <V; v++) {
                if(!sptSet[v] && graph[u][v] !=0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Vertex \tDistance from source");
        for (int i = 0; i < V; i++) {
            System.out.println(i+"\t"+(dist[i]==INF ? "INF" : dist[i]));
        }
    }
    public static void main(String[] args) {
        int[][]graph ={
            {0, 2, 4, 0, 0},
            {2, 0, 1, 7, 0},
            {4, 1, 0, 3, 0},
            {0, 7, 3, 0, 1},
            {0, 0, 0, 1, 0},
        };

        int source =0;
        dijkstra (graph,source);
    }
}