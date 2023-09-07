package Binary_Tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Binary_tree {
    static class Node{                        //  Class Node
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
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
    // creating the tree using User input

    public static Node create_tree(){
        Node root = null;
        System.out.println("Enter the data: ");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if(data==-1) return null;
        root = new Node(data);
        System.out.println("Enter the left child of " + data );
        root.left=create_tree();              //   recursive call for left subtree
        System.out.println("Enter the right child of " + data );
        root.right=create_tree();             //   recursive call for right subtree
        return root;
    }

    // Preorder Traversal


    public static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder Traversal


    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    // Postorder Traversal


    public static void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    // Level order Traversal


    static void level_order(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode==null) {
                System.out.println();
                if(q.isEmpty()) break;
                else q.add(null);
            }
            else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null) q.add(currNode.left);
                if(currNode.right!=null) q.add(currNode.right);
            }
        }
    }


    // Height of a Binary Tree

    static int height(Node root){
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }


    // Nodes in a Binary Tree

    static int node_count(Node root){
        if(root == null) return 0;
        int lc = node_count(root.left);
        int rc = node_count(root.right);
        return lc+rc+1;
    }


    //  Sum of Nodes in a Binary Tree


    static int node_sum(Node root){
        if(root == null) return 0;
        int l_sum = node_sum(root.left);
        int r_sum = node_sum(root.right);
        return l_sum+r_sum+root.data;
    }

    //  Diameter of a binary tree

    //  This method inefficient due to its Time complexity of O(n^2)


    static int diameter(Node root){
        if(root == null) return 0;
        int ldm = diameter(root.left);           //  left diameter of root
        int rdm = diameter(root.right);          //  right diameter of root
        int lht = height(root.left);             //  left height of root
        int rht = height(root.right);            //  right height of root
        int sdm = lht+rht+1;
        return Math.max(sdm,Math.max(ldm,rdm));
    }

    //  Diameter of Binary tree Efficiently

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
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println();
            System.out.println("Enter 1 for Preorder Traversal: ");
            System.out.println("Enter 2 for Inorder Traversal: ");
            System.out.println("Enter 3 for Postorder Traversal: ");
            System.out.println("Enter 4 for Postorder Traversal: ");
            System.out.println("Enter 0 to exit: ");
            choice = sc.nextInt();
            if(choice==1) {
                System.out.println("Preorder Traversal is: ");
                preorder(root);
            }
            else if(choice==2) {
                System.out.println("Inorder Traversal is: ");
                inorder(root);
            }
            else if(choice==3) {
                System.out.println("Postorder Traversal is: ");
                postorder(root);
            }
            else if(choice==4) {
                System.out.println("Level Order Traversal is: ");
                level_order(root);
            }

        }while(choice!=0);
        System.out.println("Height of our Binary Tree is "+height(root));
        System.out.println("Number of Nodes in this Binary tree is "+node_count(root));
        System.out.println("Sum of all the Nodes of this Binary Tree is "+node_sum(root));
        System.out.println("Diameter of the Binary Tree is: "+diameter(root));
        System.out.println("Diameter of the Binary Tree Via efficient operation is: "+eff_dim(root).diameter);
    }
}
