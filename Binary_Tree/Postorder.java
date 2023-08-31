package Binary_Tree;

public class Postorder {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Bnry_tree {
        static int idx=-1;
        public static Node create_tree ( int[] nodes){

            idx++;
            if (nodes[idx] == -1) return null;

            Node new_node = new Node(nodes[idx]);
            new_node.left = create_tree(nodes);
            new_node.right = create_tree(nodes);
            return new_node;
        }
        public static void postorder_traversal (Node root){
            if (root == null) return;

            postorder_traversal(root.left);
            postorder_traversal(root.right);
            System.out.print(root.data + " ");
        }
    }
    public static void main(String[] args) {
        int [] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Bnry_tree bt = new Bnry_tree();
        Node root = bt.create_tree(nodes);
        bt.postorder_traversal(root);
    }
}

