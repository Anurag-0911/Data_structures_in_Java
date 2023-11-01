package Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
    public static class edge{
        int src;
        int dst;
        int wt;
        public edge(int src,int dst,int wt){
            this.src=src;
            this.dst=dst;
            this.wt=wt;
        }
    }
    static class pair implements Comparable<pair>{
        int node;
        int path;
        public pair(int node,int path){
            this.node=node;
            this.path=path;
        }
        @Override
        public int compareTo(pair p2) {
            return this.path-p2.path;
        }
    }

    public static void create_Graph(ArrayList<edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,1,2));
        graph[0].add(new edge(0,2,4));

        graph[1].add(new edge(1,3,7));
        graph[1].add(new edge(1,2,1));

        graph[2].add(new edge(2,4,3));

        graph[3].add(new edge(3,5,1));

        graph[4].add(new edge(4,3,2));
        graph[4].add(new edge(4,5,5));
    }
    public static void dijkstra(ArrayList<edge>[] graph,int src){
        int [] dist = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        boolean [] vis = new boolean[graph.length];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(src,0));
        while(!pq.isEmpty()){
            pair curr = pq.remove();
            if(!vis[curr.node]) {
                vis[curr.node]=true;
                for(int i=0;i<graph[curr.node].size();i++){
                    edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dst;
                    int wt = e.wt;
                    if(dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                        pq.add(new pair(v,dist[v]));
                    }
                }
            }

        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    }
    public static void main(String[] args) {
        int v = 6;
        ArrayList<edge>[] graph = new ArrayList[v];
        create_Graph(graph);
        dijkstra(graph,0);
    }
}
