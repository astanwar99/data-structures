package trees.binaryTree;
import trees.node.Node;

public class BinaryTree {
    private Node root;

    public BinaryTree(){
        root = null;
    }

    public void setNode(int num) {
        this.root = new Node(num);
    }

    public BinaryTree(int key){
        root = new Node(key);
    }
}