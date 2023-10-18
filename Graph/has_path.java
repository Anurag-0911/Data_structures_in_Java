package Graph;

import java.util.ArrayList;

public class has_path {
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
    public static void create_Graph(ArrayList<edge>[] graph, int v){
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
    public static boolean haspath(ArrayList<edge>[] graph , int src, int dst, boolean[] visited){
        if(src==dst) return true;
        visited[src]=true;
        for(int i=0;i<graph[src].size();i++){
            edge e = graph[src].get(i);
            if(!visited[e.dst] && haspath(graph,e.dst,dst,visited)) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<edge> [] graph = new ArrayList[v];
        create_Graph(graph,v);
        System.out.println(haspath(graph,0,7,new boolean[v]));
    }
}
