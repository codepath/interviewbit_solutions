// Count Leaf Nodes

class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

public class Solution {
    int countLeafNodes(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return countLeafNodes(node.left) + countLeafNodes(node.right);
        }
    }
}