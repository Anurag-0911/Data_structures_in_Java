
// Kahn's Algorithm

package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



public class Topo_sort_bfs {
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
    public static void calc_indegree(ArrayList<edge>[] graph,int [] indeg){
        for(int i=0;i< graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                edge e = graph[i].get(j);
                indeg[e.dst]++;
            }
        }
    }
    public static void sort(ArrayList<edge>[] graph) {
        int [] indeg = new int[graph.length];
        calc_indegree(graph,indeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(indeg[i]==0) q.add(i);
        }

        while (!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for (int i=0;i<graph[curr].size();i++){
                edge e = graph[curr].get(i);
                indeg[e.dst]--;
                if(indeg[e.dst]==0) q.add(e.dst);
            }
        }
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<edge>[] graph = new ArrayList[v];
        create_Graph(graph);
        sort(graph);
    }
}
