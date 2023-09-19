package BST;

public class BST_Deletion {
    static  class Node{
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
    public static Node deletion(Node root,int val){
        if(val<root.data){
            root.left=deletion(root.left,val);
        }
        else if (val>root.data){
            root.right=deletion(root.right,val);
        }
        else{

            //   When root does not have any child


            if(root.left==null && root.right==null) return null;

            //   when root is having only one child


            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;

            //   when root is having both children

            Node IS = inorder_successor(root.right);
            root.data=IS.data;
            root.right=deletion(root.right,IS.data);
        }
        return root;
    }
    public static Node inorder_successor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        int [] arr = {8,5,3,1,4,10,11,14};
        Node root = null;
        for (int i=0;i<arr.length;i++){
            root=create_BST(arr[i],root);
        }
        traverse(root);
        System.out.println();
        deletion(root,8);
        traverse(root);
    }
}
