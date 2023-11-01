package Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Kruskals_algo {
    static class edge implements Comparable<edge>{
        int src;
        int dst;
        int wt;
        public edge(int src,int dst,int wt) {
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }

        @Override
        public int compareTo(edge e2) {
            return this.wt-e2.wt;
        }
    }
    static int v = 4;
    static int [] prnt = new int[v];
    static int [] rank = new int[v];
    public static void init(){
        for(int i=0;i<prnt.length;i++){
            prnt[i]=i;
        }
    }
    public static int find(int val){
        if(val==prnt[val]) return val;
        return find(prnt[val]);
    }
    public static void union(int a, int b){
        int prntA = find(a);
        int prntB = find(b);
        if(rank[prntA]==rank[prntB]){
            prnt[prntB] = prntA;
            rank[prntA]++;
        }
        else if(rank[prntA]<rank[prntB]) prnt[prntA] = prntB;
        else prnt[prntB]=prntA;
    }
    public static void create_Graph(ArrayList<edge> graph){

        graph.add(new edge(0,1,10));
        graph.add(new edge(0,2,15));
        graph.add(new edge(0,3,30));

        graph.add(new edge(1,0,10));
        graph.add(new edge(1,3,40));

        graph.add(new edge(2,0,15));
        graph.add(new edge(2,3,50));

        graph.add(new edge(3,0,30));
        graph.add(new edge(3,1,40));
        graph.add(new edge(3,2,50));
    }

    public static void kruskal(ArrayList<edge> edge, int v){
        Collections.sort(edge);
        int mcst = 0;
        int count = 0;
        for(int i=0;count<v-1;i++){
            edge e = edge.get(i);
            int parA = find(e.src);
            int parB = find(e.dst);
            if(parA!=parB){
                union(e.src,e.dst);
                mcst += e.wt;
                count++;
            }
        }
        System.out.println(mcst);
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<edge> graph = new ArrayList<>();
        create_Graph(graph);
        init();
        kruskal(graph,v);

    }
}
