class PrimsMST {

    private static final int V = 5;

    void findMST (int [][] graph) {
        int [] parent = new int [V];
        int [] key =new int [V];
        boolean [] mstSet =new boolean [V];

        for (int i = 0; i < V ;i++) {
            key [i] = Integer.MAX_VALUE;
        }
        key[0] =0;
        parent[0]=-1;

        for (int count =0;count < V-1; count++) {
            int u =minKey(key, mstSet);
            mstSet[u] =true;

            for (int v=0;v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] =u;
                    key[v]=graph[u][v];
                }
            }
        }
        for (int i=1;i<V;i++) {
            System.out.println(parent[i]+" - "+i+"\t"+graph[i][parent[i]]);
        }
    }
    int minKey(int[] key,boolean[] mstSet) {
        int min =Integer.MAX_VALUE, minIndex=-1;
        for(int v=0;v<V;v++) {
            if(!mstSet[v] && key[v] < min) {
                min=key[v];
                minIndex=v;
            }
        }
        return minIndex;
    }

    
}
