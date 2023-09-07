package Binary_Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Top_view {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Info{
        Node node;
        int hd;
        Info(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    static class Bnry_tree {
        static int idx=-1;
        public static Node create_tree ( int[] nodes){

            idx++;
            if (nodes[idx] == -1) return null;

            Node new_node = new Node(nodes[idx]);
            new_node.left = create_tree(nodes);
            new_node.right = create_tree(nodes);
            return new_node;
        }
        public static void topview (Node root){
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer,Node> hp = new HashMap<>();
            q.add(new Info(root,0));
            int min=0;int max=0;

            while(!q.isEmpty()){
                Info curr = q.remove();
                if(curr==null) {
                    if (q.isEmpty()) break;
                    else q.add(null);
                }
                else{
                    if(!hp.containsKey(curr.hd)){
                        hp.put(curr.hd,curr.node);
                    }
                    if(curr.node.left!=null){
                        q.add(new Info(curr.node.left,curr.hd-1));
                        min = Math.min(min,curr.hd-1);
                    }
                    if(curr.node.right!=null){
                        q.add(new Info(curr.node.right,curr.hd+1));
                        max = Math.max(min,curr.hd+1);
                    }
                }

            }
            for(int i=min;i<=max;i++){
                System.out.print(hp.get(i).data+" ");
            }

        }
    }
    public static void main(String[] args) {
        int [] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Bnry_tree bt = new Bnry_tree();
        Node root = bt.create_tree(nodes);
        bt.topview(root);
    }
}

