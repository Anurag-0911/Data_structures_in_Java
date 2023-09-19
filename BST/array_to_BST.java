package BST;

public class array_to_BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
        public static Node create_balanced_BST(int[] arr,int low,int high){
            if(low>high) return null;
            int mid=(low+high)/2;
            Node root = new Node(arr[mid]);
            root.left = create_balanced_BST(arr,low,mid-1);
            root.right = create_balanced_BST(arr,mid+1,high);
            return root;
        }
        public static void preorder_traversal (Node root){
            if (root == null) return;
            System.out.print(root.data + " ");
            preorder_traversal(root.left);
            preorder_traversal(root.right);
        }
        public static void main(String[] args) {
            int [] arr = {3,5,6,8,10,11,12};
            Node root = create_balanced_BST(arr,0,arr.length-1);
            System.out.println();
            preorder_traversal(root);
        }
    }
}
