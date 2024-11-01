import java.util.ArrayList;
import java.util.List;

class PrimMST {
    private static final int V=7;

    int minKey(int [] key, Boolean[] mstSet) {
        int min = Integer.MAX_VALUE,minIndex = -1;
        for (int v=0;v<V;v++) {
            if(mstSet[v] ==false && key[v] <min) {
                min =key[v];
                minIndex =v;
            }
        }
        return minIndex;
    }
    
    void printMST(int [] parent,int [][] graph) {
        int totalCost=0;
        System.out.println("Edge \tWeight");
        for(int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - "+ i +"\t"+graph[i][parent[i]]);
            totalCost +=graph[i][parent[i]];
        }
        System.out.println("Cost of Minimum Spanning Tree:"+totalCost);
    }

    void primMethod(List<int[]>edges) {
        int [][]graph = new int [V][V];

        for(int[] edge :edges) {
            int u=edge[0];
            int v=edge[1];
            int weight=edge[2];
            graph[u][v]=weight;
            graph[v][u]=weight;
        }

        int [] parent =new int[V];
        int [] key =new int [V];
        Boolean [] mstSet =new Boolean[V];

        for (int i=0;i<V;i++) {
            key[i]=Integer.MAX_VALUE;
            mstSet[i] =false;
        }
        key[0]=0;
        parent[0] =-1;

        for (int count =0;count <V;count++){
            int u=minKey(key,mstSet);
            mstSet[u]=true;

            for(int v=0;v<V;v++) {
                if(graph[u][v] !=0 && mstSet[v]==false && graph[u][v] < key[v]){
                    parent[v]=u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent,graph);
    }

    public static void main(String[] args) {
        PrimMST mst =new PrimMST();

        List<int[]> edges =new ArrayList<>();
        edges.add(new int []{6, 1, 10});
        edges.add(new int []{6, 5, 25});
        edges.add(new int []{1, 2, 28});
        edges.add(new int []{2, 3, 16});
        edges.add(new int []{2, 0, 14});
        edges.add(new int []{5, 0, 24});
        edges.add(new int []{5, 4, 22});
        edges.add(new int []{0, 4, 18});
        edges.add(new int []{4, 3, 12});

        mst.primMethod(edges);
    }
}

