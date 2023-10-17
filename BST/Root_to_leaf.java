package BST;

import java.util.ArrayList;

public class Root_to_leaf {
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public Node create_BST(int val, Node root){
        if(root==null){
            root=new Node(val);
            return root;
        }
//        if(root==null){
//            root = new Node(val);
//            return root;
//        }
        if(val<root.data){
            root.left=create_BST(val,root.left);
        }
        else if(val>root.data){
            root.right=create_BST(val,root.right);
        }
        return root;
    }
    public static void traverse(Node root){
        if(root == null) return;
        traverse(root.left);
        System.out.print(root.data+" ");
        traverse(root.right);
    }
    public static void RootToLeaf(Node root, ArrayList<Integer> path){
        if (root==null) return;
        path.add(root.data);
        if(root.left==null && root.right==null){
            print_path(path);
        }
        RootToLeaf(root.left,path);
        RootToLeaf(root.right,path);
        path.remove(path.size()-1);

    }
    public static void print_path(ArrayList<Integer> path){
        for(int i = 0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        int [] arr = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        Root_to_leaf rf = new Root_to_leaf();

        for (int i=0;i<arr.length;i++){

            root=rf.create_BST(arr[i],root);
        }
        traverse(root);
        System.out.println();
        RootToLeaf(root,new ArrayList<>());
    }
}
