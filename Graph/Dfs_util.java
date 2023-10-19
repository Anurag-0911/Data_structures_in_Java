package Graph;

import java.util.ArrayList;

public class Dfs_util {
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
        graph[0].add(new edge(0, 1, 1));
        graph[0].add(new edge(0, 2, 1));

        graph[1].add(new edge(1, 0, 1));
        graph[1].add(new edge(1, 3, 1));

        graph[2].add(new edge(2, 0, 1));
        graph[2].add(new edge(2, 4, 1));

        graph[3].add(new edge(3, 1, 1));
        graph[3].add(new edge(3, 4, 1));
        graph[3].add(new edge(3, 5, 1));

        graph[4].add(new edge(4, 2, 1));
        graph[4].add(new edge(4, 3, 1));
        graph[4].add(new edge(4, 5, 1));

        graph[5].add(new edge(5, 3, 1));
        graph[5].add(new edge(5, 4, 1));
        graph[5].add(new edge(5, 6, 1));
        graph[6].add(new edge(6, 5, 1));
        // Fix indices: 8 and 7 are out of bounds for an ArrayList of size 9.
        graph[8].add(new edge(8, 7, 1)); // This should be graph[7].add(new edge(7, 8, 1));
        graph[7].add(new edge(7, 8, 1)); // This should be graph[8].add(new edge(8, 7, 1));
    }
    public static void dfs(ArrayList<edge>[] graph){
        boolean [] vis = new boolean[graph.length];
        for(int i=0;i< graph.length;i++){
            if(!vis[i]){
                dfsutil(graph,i,vis);
            }
        }
    }
    public static void dfsutil(ArrayList<edge>[] graph, int curr, boolean[] visited){
        System.out.print(curr+" ");
        visited[curr]= true;
        for(int i =0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!visited[e.dst]){
                dfsutil(graph,e.dst,visited);
            }
        }
    }
    public static void main(String[] args) {
        int v = 9;
        ArrayList<edge>[] graph = new ArrayList[v];
        create_Graph(graph);
        dfs(graph);
    }
}
