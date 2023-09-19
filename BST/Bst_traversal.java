package BST;

public class Bst_traversal {
    static  class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node create_BST(int val,Node root){
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
    public static boolean search(Node root,int key){
        if(root==null) return false;
        if(root.data==key){

            return true;
        }
        if(key < root.data){
            return search(root.left,key);
        }
        else if(key > root.data){
            return search(root.right,key);
        }
        return false;
    }
    public static void main(String[] args) {
        int [] arr = {5,1,3,4,2,6};
        int key=9;
        int key2=4;
        Node root = null;
        for(int i=0;i<arr.length;i++){
            root=create_BST(arr[i],root);
        }
        traverse(root);
        System.out.println();
        boolean b = search(root,key);
        if(b){
            System.out.println("Key "+key+" found in the BST");
        }
        else{
            System.out.println("Key "+key+" doesn't found in the BST");
        }
        boolean b2 = search(root,key2);
        if(b2){
            System.out.println("Key "+key2+" found in the BST");
        }
        else{
            System.out.println("Key "+key2+" doesn't found in the BST");
        }
    }
}
