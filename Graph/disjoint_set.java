package Graph;

public class disjoint_set {
    static int v = 7;
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
    public static void main(String[] args) {

        init();
        System.out.println(find(3));
        union(1,3);
        System.out.println(find(3));
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1,5);
        System.out.println(find(5));
    }
}
