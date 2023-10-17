package BST;

import Binary_Tree.preorder;

public class Mirror_BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node create_BST(int val, Node root){
        if(root==null){
            root = new Node(val);
            return root;
        }
        if(val<=root.data){
            root.left=create_BST(val,root.left);
        }
        else if(val>=root.data){
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
    public static Node mirror(Node root){
        if(root==null) return null;
        Node left_mirror = mirror(root.left);
        Node right_mirror = mirror(root.right);
        root.left=right_mirror;
        root.right=left_mirror;
        return root;
    }
    public static void preorder_traversal (Node root){
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder_traversal(root.left);
        preorder_traversal(root.right);
    }
    public static void main(String[] args) {
        int [] arr = {8,5,10,3,6,11};
        Node root = null;
        for (int i=0;i<arr.length;i++){

            root=create_BST(arr[i],root);
        }
        traverse(root);
        System.out.println();
        mirror(root);
        System.out.println("Mirror BST:- ");
        preorder_traversal(root);
    }
}
