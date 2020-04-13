package trees.node;

public class Node {
    public int key;
    public Node left, right;

    public Node(int key){
        this.key = key;
        left = null;
        right = null;
    }
}