// Path Sums with DFS

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public int hasPathSum(TreeNode A, int B) {

	    boolean status = sum(A, 0, B);

	    return status ? 1 : 0;
	}

	public boolean sum(TreeNode A, int curSum, int reqSum) {

	    if (A == null) {
	        return false;
	    }

	    if (A.left == null && A.right == null) {
	        curSum += A.val;
	        if (curSum == reqSum)
	            return true;
	        return false;
	    }

	    int sum = curSum + A.val;

	    return sum(A.left, sum, reqSum) || sum(A.right, sum, reqSum);

	}

}
