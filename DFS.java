import java.util.*;

class DFS {
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    DFS(int vertices){
        adjLists=new LinkedList[vertices];
        visited =new boolean[vertices];

        for (int i =0;i < vertices ;i++)
            adjLists[i]=new LinkedList<Integer>();

    }

    void addEdge(int src,int dest) {
        adjLists[src].add(dest);
    }

    void DFSMain (int vertex) {
        visited [vertex]=true;
        System.out.print(vertex + " ");

        Iterator<Integer> ite =adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj=ite.next();
            if(!visited[adj])
                DFSMain(adj);
        }
    }

    public static void main(String[] args) {
        DFS g=new DFS(4);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,3);

        System.out.println("Following is Dept First Traversal");
        
        g.DFSMain(2);

    }
    
}
