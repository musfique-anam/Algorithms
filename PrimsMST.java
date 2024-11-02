class PrimMST {
    
    private static final int V = 6;  
    
    void primMethod(int [][] graph) {

        int[] parent = new int[V];
        int[] key = new int[V];
        Boolean[] mstSet = new Boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;          
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {  
                if (graph[u][v] != 0 && mstSet[v]==false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph);
    }

    int minKey(int[] key, Boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    void printMST(int[] parent, int[][] graph) {
        int totalCost = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {           
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            totalCost += graph[i][parent[i]];
        }
        System.out.println("Cost of Minimum Spanning Tree:"+totalCost);
    }

    public static void main(String[] args) {
        PrimMST mst = new PrimMST();
        int [][] graph =new int [][] {
            {0,2,0,0,0,1},
            {2,0,3,0,0,0},
            {0,3,0,1,0,0},
            {0,0,1,0,2,0},
            {0,0,0,2,0,5},
            {1,6,0,0,5,0} };   

        mst.primMethod(graph);
    }
}
