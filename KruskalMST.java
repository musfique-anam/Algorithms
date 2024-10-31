import java.util.Arrays;

class KruskalMST{

    class Edge implements Comparable<Edge> {
        int src, dest, weigth;

        Edge(int src,int dest, int weight) {
            this.src= src;
            this.dest= dest;
            this.weight =weight;
        }

        public int compareTo(Edge other) {
            return this.weight -other.weight;
        }
    }

    int find(int [] parent, int i) {
        if(parent[i] !=i)
            parent[i] =find(parent, parent [i]);
        return parent[i];
    }
}