// Interview Question 1: Convert a Linked List to BST

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class Solution {
    public TreeNode sortedLinkedListToBalancedBST(ListNode node) {
        if (node == null) {
            return null;
        } else if (node.next == null) {
            return new TreeNode(node.val);
        }
        
        // Copy linked list to array (there are no space constraints)
        ArrayList<Integer> a = new ArrayList<Integer>();
        ListNode curr = node;
        while (null != curr) {
            a.add(curr.val);
            curr = curr.next;
        }
        
        return tree(a, 0, a.size()-1);
    }
    
    private TreeNode tree(ArrayList<Integer> a, int i, int j) {
        if (i == j) {
            return new TreeNode(a.get(i));
        }
        
        int mid = (i+j)/2;
        TreeNode b = new TreeNode(a.get(mid));
        if (i < mid) {
            b.left = tree(a, i, mid-1);
        }
        if (mid < j) {
            b.right = tree(a, mid+1, j);
        }
        
        return b;
    }
}
