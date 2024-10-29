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
        }
    }
    
}
