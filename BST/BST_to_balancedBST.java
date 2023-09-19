package BST;

import java.util.ArrayList;

public class BST_to_balancedBST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static void inorder(Node root, ArrayList<Integer> al){
        if(root==null) return;
        inorder(root.left,al);
        al.add(root.data);
        inorder(root.right,al);
    }
    public static Node final_bst(ArrayList<Integer> al,int low,int high){
        if(low>high) return null;

        int mid=(low+high)/2;
        Node root = new Node(al.get(mid));
        root.left = final_bst(al,low,mid-1);
        root.right = final_bst(al,mid+1,high);
        return root;
    }
    public static Node bal_bst(Node root){
        ArrayList<Integer> al = new ArrayList<>();
        inorder(root,al);
        root = final_bst(al,0,al.size()-1);
        return root;
    }
    public static void preorder(Node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right =  new Node(12);
        root = bal_bst(root);
        preorder(root);
    }
}
