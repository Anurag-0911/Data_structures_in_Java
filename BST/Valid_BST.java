package BST;

public class Valid_BST {
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
    public static boolean validate(Node root,Node min,Node max){
        if(root==null) return true;
        if(min!=null && root.data<=min.data) return false;
        if(max!=null && root.data>=max.data) return false;
        return(validate(root.left,min,root) && validate(root.right,root,max));
    }
    public static void main(String[] args) {
        int [] arr = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for (int i=0;i<arr.length;i++){

            root=create_BST(arr[i],root);
        }
        traverse(root);
        System.out.println();
        if(validate(root,null,null)){
            System.out.println("It is a Valid BST.");
        }
        else{
            System.out.println("This BST is not Valid.");
        }

    }
}
