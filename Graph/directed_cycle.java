package Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class directed_cycle {
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
    public static void create_Graph(ArrayList<edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
//        graph[0].add(new edge(0, 1, 1));

        graph[0].add(new edge(0, 2, 1));

        graph[1].add(new edge(1, 0, 1));
//        graph[1].add(new edge(1, 2, 1));

//        graph[2].add(new edge(2, 0, 1));
        graph[2].add(new edge(2, 3, 1));

        graph[3].add(new edge(3, 0, 1));
//        graph[3].add(new edge(3, 4, 1));

//        graph[4].add(new edge(4, 3, 1));
    }
    public static boolean iscycle(ArrayList<edge>[] graph){
        boolean [] vis = new boolean[graph.length];
        boolean [] stack = new boolean[graph.length];
        for(int i=0;i< graph.length;i++){
            if(!vis[i]){
                if(detectcycle(graph,vis,stack,i)) return true;
            }
        }
        return false;
    }
    public static boolean detectcycle(ArrayList<edge>[] graph,boolean[] vis, boolean[] stack,int curr){
        vis[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(stack[e.dst]) return true;
            if(!vis[e.dst] && detectcycle(graph,vis,stack,e.dst)) return true;
        }
        stack[curr]=false;
        return false;
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<edge>[] graph = new ArrayList[v];
        create_Graph(graph);
        System.out.println(iscycle(graph));
    }
}
