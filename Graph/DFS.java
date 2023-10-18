package Graph;

import java.util.ArrayList;

public class DFS {
    public static class edge{
        int src;
        int dst;
        int wt;
        edge(int src,int dst,int wt){
            this.src=src;
            this.dst=dst;
            this.wt=wt;
        }
    }
    public static void create_Graph(ArrayList<edge>[] graph,int v){
        for(int i = 0 ;i<v;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0,1,1));
        graph[0].add(new edge(0,2,1));

        graph[1].add(new edge(1,0,1));
        graph[1].add(new edge(1,3,1));

        graph[2].add(new edge(2,0,1));
        graph[2].add(new edge(2,4,1));

        graph[3].add(new edge(3,1,1));
        graph[3].add(new edge(3,4,1));
        graph[3].add(new edge(3,5,1));

        graph[4].add(new edge(4,3,1));
        graph[4].add(new edge(4,2,1));
        graph[4].add(new edge(4,5,1));

        graph[5].add(new edge(5,3,1));
        graph[5].add(new edge(5,4,1));
        graph[5].add(new edge(5,6,1));

        graph[6].add(new edge(6,5,1));
    }
    public static void dfs(ArrayList<edge>[] graph,int curr,boolean[] visited){
        System.out.print(curr+" ");
        visited[curr]= true;
        for(int i =0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!visited[e.dst]){
                dfs(graph,e.dst,visited);
            }
        }
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<edge> [] graph = new ArrayList[v];
        create_Graph(graph,v);
        dfs(graph,0,new boolean[v]);
    }
}
