package BST;

import jdk.jshell.spi.SPIResolutionException;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class merge_BST {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }

    public static void inorder(Node root, ArrayList<Integer> arr){
        if(root == null) return;
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
    public static Node array_to_BST(ArrayList<Integer> ans,int low,int high){
        if(low>high) return null;
        int mid=(low+high)/2;
        Node root = new Node(ans.get(mid));
        root.left = array_to_BST(ans,low,mid-1);
        root.right = array_to_BST(ans,mid+1,high);
        return root;

    }
    public static Node mergeBST(Node root1,Node root2){
        int i=0,j=0;
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root1,arr1);
        inorder(root2,arr2);
        while (i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<=arr2.get(j)){
                ans.add(arr1.get(i));
                i++;
            }
            else {
                ans.add(arr2.get(j));
                j++;
            }
        }
        while (i<arr1.size()){
            ans.add(arr1.get(i));
            i++;
        }
        while (j<arr2.size()){
            ans.add(arr2.get(j));
            j++;
        }
        return array_to_BST(ans,0,ans.size()-1);
    }
    public static void preorder(Node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right= new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);
        Node root = mergeBST(root1,root2);
        preorder(root);
    }
}
