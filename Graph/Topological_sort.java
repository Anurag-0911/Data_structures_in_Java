package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class Topological_sort {
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

        graph[2].add(new edge(2, 3, 1));

        graph[3].add(new edge(3, 1, 1));

        graph[4].add(new edge(4, 0, 1));
        graph[4].add(new edge(4, 1, 1));

        graph[5].add(new edge(5, 0, 1));
        graph[5].add(new edge(5, 2, 1));
    }
    public static void topo_sort(ArrayList<edge>[] graph){
        boolean [] vis = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!vis[i]) sortutil(graph,vis,st,i);
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }
    public static void sortutil(ArrayList<edge>[] graph,boolean [] vis, Stack<Integer> st,int curr) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if(!vis[e.dst]) sortutil(graph,vis,st,e.dst);
        }
        st.push(curr);
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<edge>[] graph = new ArrayList[v];
        create_Graph(graph);
        topo_sort(graph);
    }
}
