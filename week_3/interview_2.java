// Interview Question 2: Sort tree by columns
// Write an algorithm which takes as its input a binary tree and outputs a singly-linked list of its values ordered by column first and row second.

/*Example:

Input tree:
          5
         / \
        4   8
       /   / \
      9   6   4
     / \     / \
    7   2   5   1
In the above tree, there are 7 columns, three of which have two nodes: [4, 2], [5, 6], and [8,5]. Therefore the algorithm would return a linked list with the following characters: 7→9→4→2→5→6→8→5→4→1.

*/

public class Solution {
   /*
     * Node for a binary tree node
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /*
     * Node for a singly linked list
     */
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }


    }

    /*
     * Helper function to add the given node (next) to the tail of the given list (head)
     */
    static void addToTail(ListNode head, ListNode next) {
        if (head == null || next == null) {
            head = next;
            return;
        }
        ListNode cur = head;

        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = next;
    }

    /*
     * Helper function to print a linked list
     */
    static void printLinkedList(final ListNode head) {
        if (head == null)
            return;
        ListNode cur = head;
        while(cur.next != null) {
            System.out.print(cur.val + " ->");
            cur = cur.next;
        }
        System.out.print(cur.val);
    }


    ListNode computeCols(TreeNode head) {
        // index of the array is the column index
        HashMap<Integer, ListNode> listNodeHeadsPerCol = new HashMap<>();

        MinMaxCol minMaxCol = new MinMaxCol();
        computeColsUtil(head, listNodeHeadsPerCol, 0, minMaxCol);
        ListNode res = listNodeHeadsPerCol.get(minMaxCol.min);
        ListNode cur = res;
        for (int i = minMaxCol.min + 1; i <= minMaxCol.max; i++) {
            ListNode tmp = listNodeHeadsPerCol.get(i);
            addToTail(cur, tmp);
            cur = tmp;
        }
        return res;
    }

    /*
     * Helper class to keep track of the min and max column
     */
    class MinMaxCol {
        int min;
        int max;

        public MinMaxCol() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }
    }

    void computeColsUtil(TreeNode head, HashMap<Integer, ListNode> listNodeHeadsPerCol, int col, MinMaxCol minMaxCol) {
        if (head == null) return;

        if (listNodeHeadsPerCol.get(col) != null) {
            addToTail(listNodeHeadsPerCol.get(col), new ListNode(head.val));
        } else {
            listNodeHeadsPerCol.put(col, new ListNode(head.val));
        }
        computeColsUtil(head.left, listNodeHeadsPerCol, col - 1, minMaxCol);
        computeColsUtil(head.right, listNodeHeadsPerCol, col + 1, minMaxCol);

        minMaxCol.min = Math.min(col, minMaxCol.min);
        minMaxCol.max = Math.max(col, minMaxCol.max);

    }

    /*
     Input tree:
          5
         / \
        4   8
       /   / \
      9   6   4
     / \     / \
    7   2   5   1
     */
    TreeNode constructTree() {
        TreeNode treeHead = new TreeNode(5);
        treeHead.left = new TreeNode(4);
        treeHead.right = new TreeNode(8);
        treeHead.left.left = new TreeNode(9);
        treeHead.left.left.left = new TreeNode(7);
        treeHead.left.left.right = new TreeNode(2);
        treeHead.right.left = new TreeNode(6);
        treeHead.right.right = new TreeNode(4);
        treeHead.right.right.left = new TreeNode(5);
        treeHead.right.right.right = new TreeNode(1);
        return treeHead;
    }

    void test() {
        TreeNode testTree = constructTree();
        printLinkedList(computeCols(testTree));
    }
}
