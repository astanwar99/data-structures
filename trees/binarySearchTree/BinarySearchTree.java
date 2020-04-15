package trees.binarySearchTree;
import trees.node.Node;

public class BinarySearchTree{
    private Node root;

    public BinarySearchTree(){
        root = null;
    }

    public void setNode(int num) {
        this.root = new Node(num);
    }

    public BinarySearchTree(int key){
        root = new Node(key);
    }

    public BinarySearchTree(int[] ar) {
        int n = ar.length;
        root = new Node(ar[0]);

        for(int i = 1; i < n; i++) {
            push(ar[i]);
        }
    }

    //Wrapper over recursive
    public void push(int num) {
        push(num, this.root);
    }

    public Node search(int query) {
        return search(query, this.root);
    }

    public void delete(int key) {
        this.root = delete(this.root, key);
    }

    public void inOrder() {
        inOrder(this.root);
        System.out.println();
    }

    public void preOrder() {
        preOrder(this.root);
        System.out.println();
    }

    public void postOrder() {
        postOrder(this.root);
        System.out.println();
    }

    public Node lca(int n1, int n2) {
        Node N1 = search(n1);
        Node N2 = search(n2);
        if(N1 != null && N2 != null)
            return lca(this.root, n1, n2);
        else{
            System.out.println("Given node(s) doesn't exist");
            return null;
        }
    }

    Node search(int query, Node root) {
        if(root == null) {
            return null;
        }
        if(root.key == query){
            return root;
        }else if(root.key > query){
            return search(query, root.left);
        }else{
            return search(query, root.right);
        }
    }

    void push(int num, Node root){
        if(this.root == null) {
            this.root = new Node(num);
        }else{
            if(num < root.key){
                if(root.left == null)
                    root.left = new Node(num);
                else
                    push(num, root.left);
            }else{
                if(root.right == null)
                    root.right = new Node(num);
                else
                    push(num, root.right);
            }
        }
    }

    Node delete(Node node, int key) {
        if(node == null)
            return root;
        
        if(key < node.key)
            node.left = delete(node.left, key);
        else if(key > node.key)
            node.right = delete(node.right, key);
        else {
            if(node.left == null)
                return node.right;
            else if(node.right == null)
                return node.left;

            node.key = minVal(node.right);
            node.right = delete(node.right, node.key);
        }
        return node;

    }

    int minVal(Node node) {
        int minVal = node.key;
        while(node.left != null) {
            minVal = node.left.key;
            node = node.left;
        }
        return minVal;
    }

    void inOrder(Node node) {
        if(node == null)
            return;

        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);
    }

    void preOrder(Node node) {
        if(node == null)
            return;
        
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void postOrder(Node node) {
        if(node == null)
            return;
        
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key + " ");
    }

    Node lca(Node node, int n1, int n2) {
        while(node != null) {
            if(node.key > n1 && node.key > n2)
                node = node.left;
            else if(node.key < n1 && node.key < n2)
                node = node.right;
            else
                break;
        } 
        return node;
    }


}

class Tree {
    public static void main(String[] args) {
        //         20
        //     8       22
        // 4       12
        //     10      14
        int[] ar = {20, 8, 22, 4, 12, 10, 14};
        BinarySearchTree tree = new BinarySearchTree(ar);

        try {
            Node t = tree.lca(14, 4);
            System.out.println(t.key);
        } catch (Exception e) {
            System.out.println(e);
        }
        tree.inOrder();
    }
}