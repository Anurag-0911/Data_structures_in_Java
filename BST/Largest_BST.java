package BST;

public class Largest_BST {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static class Info{
        boolean isVal;
        int size;
        int min;
        int max;
        Info(boolean isVal,int size,int min,int max){
            this.isVal=isVal;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static int maxlength = 0;
    public static Info maxBST(Node root){

        if(root==null) return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        Info leftinfo = maxBST(root.left);
        Info rightinfo = maxBST(root.right);
        int curr_size = leftinfo.size+rightinfo.size+1;
        int min = Math.min(root.data,Math.min(leftinfo.min,rightinfo.min));
        int max = Math.max(root.data,Math.max(leftinfo.max,rightinfo.max));
        if(root.data<=leftinfo.max || root.data>=rightinfo.min) return new Info(false,curr_size,min,max);
        if(leftinfo.isVal && rightinfo.isVal){
            maxlength = Math.max(maxlength,curr_size);
            return new Info(true,maxlength,min,max);
        }
        return new Info(false,curr_size,min,max);

    }


    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        Info ans = maxBST(root);
        System.out.println("The size of largest BST is "+maxlength);

    }
}
