package Graph;
//
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class BFS{
//    public static class edge{
//        int src;
//        int dst;
//        int wt;
//        edge(int src,int dst,int wt){
//            this.src=src;
//            this.dst=dst;
//            this.wt=wt;
//        }
//    }
//    public static void create_graph(ArrayList<edge> [] graph,int v){
//        for(int i=0;i<v;i++){
//            graph[i]=new ArrayList<>();
//        }
//        graph[0].add(new edge(0,1,1));
//        graph[0].add(new edge(0,2,1));
//
//        graph[1].add(new edge(1,0,1));
//        graph[1].add(new edge(1,3,1));
//
//        graph[2].add(new edge(2,0,1));
//        graph[2].add(new edge(2,4,1));
//
//        graph[3].add(new edge(3,1,1));
//        graph[3].add(new edge(3,4,1));
//        graph[3].add(new edge(3,5,1));
//
//        graph[4].add(new edge(4,2,1));
//        graph[4].add(new edge(4,3,1));
//        graph[4].add(new edge(4,5,1));
//
//        graph[5].add(new edge(5,3,1));
//        graph[5].add(new edge(5,4,1));
//        graph[5].add(new edge(5,6,1));
//        graph[5].add(new edge(5,5,1));
//
//    }
//    public static void bfs(ArrayList<edge>[] graph){
//        Queue<Integer> q = new LinkedList<>();
//        boolean [] visited = new boolean[graph.length];
//        q.add(0);
//        while (!q.isEmpty()) {
//            int curr = q.remove();
//            if(!visited[curr]){
//                System.out.print(curr+" ");
//                visited[curr]=true;
//                for (int i = 0; i < graph[curr].size(); i++) {
//                    edge e = graph[curr].get(i);
//                    q.add(e.dst);
//                }
//            }
//        }
//    }
//    public static void main(String[] args) {
//        int v = 7;
//        ArrayList<edge>[] graph = new ArrayList[v];
//        create_graph(graph,v);
//        bfs(graph);
//    }
//}
//
//
//
//
//
//
//
//
//
//












import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void create_Graph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));
        graph[6].add(new Edge(6,5,1));

    }
    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean [] vis = new boolean[graph.length];
        q.add(0);

        while (!q.isEmpty()){
            int curr = q.remove();
            if (!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }

            }
        }
    }
    public static void main(String[] args) {
        int v=7;
        ArrayList<Edge> [] graph = new ArrayList[v];
        create_Graph(graph);
        bfs(graph);
    }
}
