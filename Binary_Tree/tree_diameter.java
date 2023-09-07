package Binary_Tree;

import java.util.Scanner;

public class tree_diameter {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    static class info{                          //  class info for calculating diameter of a binary tree efficiently i.e, O(n)
        int diameter;
        int height;
        info(int diameter,int height){
            this.diameter=diameter;
            this.height=height;
        }
    }
    public static Node create_tree() {
        Node root = null;
        System.out.println("Enter the Data: ");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data == -1) return null;
        root = new Node(data);
        System.out.println("Enter the left child of " + data);
        root.left = create_tree();
        System.out.println("Enter the right child of " + data);
        root.right = create_tree();
        return root;
    }
    static int height(Node root){
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }
    static int diameter(Node root){
        if(root==null) return 0;
        int ldm = diameter(root.left);
        int rdm = diameter(root.right);
        int lht = height(root.left);
        int rht = height(root.right);
        int self = lht+rht+1;
        return Math.max(self,Math.max(ldm,rdm));
    }
    static info eff_dim(Node root){
        if(root == null) return new info(0,0);
        info left_all = eff_dim(root.left);
        info right_all = eff_dim(root.right);
        int dmtr = Math.max(Math.max(left_all.diameter, right_all.diameter),left_all.height+right_all.height+1);
        int hght = Math.max(left_all.height,right_all.height)+1;
        return new info(dmtr,hght);
    }
    public static void main(String[] args) {
        Node root = create_tree();
        System.out.println("Diameter of provided Binary Tree is: "+diameter(root));
        System.out.println("Diameter of provided Binary Tree Via efficient operatin is: "+eff_dim(root).diameter);
    }
}
