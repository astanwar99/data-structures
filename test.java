import trees.binarySearchTree.*;

class test{
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        bt.setNode(10);
        bt.push(5);
        bt.push(21);

        bt.inOrder();
    }
}