// Path Sum with BFS
// https://www.interviewbit.com/problems/path-sum/
//Given a binary tree and a sum, determine if the tree has a root-to-leaf
//path such that adding up all the values along the path equals the given sum.

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 **/
 
public class Solution {
    class Cell {
        TreeNode t;
        int sum_from_root;
        Cell(TreeNode x, int sum) {
            t = x;
            sum_from_root = sum;
        }
    }

    public int hasPathSum(TreeNode a, int b) {
        Queue<Cell> q = new LinkedList<>();
        if (a == null) return 0;
	    
        q.add(new Cell(a, 0));
	    
        while (!q.isEmpty()){
            Cell cur = q.poll();
            int sum = cur.sum_from_root + cur.t.val;
            if (cur.t.left == null && cur.t.right == null
	              && sum == b) return 1;
	        
            if (cur.t.left != null) q.add(new Cell(cur.t.left, sum));
            if (cur.t.right != null) q.add(new Cell(cur.t.right, sum));
        }
        return 0;
    }
}
