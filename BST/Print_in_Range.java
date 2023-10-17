package BST;

import static BST.Print_in_Range.create_BST;

public class Print_in_Range {
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
    public static void print_in_range(Node root,int k1,int k2){
        if(root==null) return;
        if(root.data>=k1 && root.data<=k2){
            print_in_range(root.left,k1,k2);
            System.out.print(root.data+" ");
            print_in_range(root.right,k1,k2);
        }
        else if(root.data>=k1){
            print_in_range(root.right,k1,k2);
        }
        else if(root.data<=k2){
            print_in_range(root.left,k1,k2);
        }
    }
    public static void main(String[] args) {
        int [] arr = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for (int i=0;i<arr.length;i++){

            root=create_BST(arr[i],root);
        }
        traverse(root);
        System.out.println();
        print_in_range(root,5,12);


    }
}
