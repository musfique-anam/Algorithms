import java.util.*;

class BFS {

    static void addEdge(List<List<Integer>> adj,int u,int v){
        adj.get(u).add(V);
        adj.get(v).add(u);
    }

    public static void main(String[] args){
        int V=5;
        List<List<Integer>> adj = new ArrayList<>(V);
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,3);
        addEdge(adj,1,4);
        addEdge(adj,2,4);

        System.out.println("BFS starting from 0:");
        bfs(adj,0);

    }
}