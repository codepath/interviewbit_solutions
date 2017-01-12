// Compare Trees
// https://www.interviewbit.com/problems/identical-binary-trees/
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
	public int isSameTree(TreeNode A, TreeNode B) {

	    return sameTree(A, B);

	}

	public int sameTree(TreeNode A, TreeNode B) {

	    if (A == null && B == null)
	        return 1;

	    if (A == null || B == null)
	        return 0;

	    if (A.val != B.val)
	        return 0;


	    int num = 1;
	    num = num & sameTree(A.left, B.left) & sameTree(A.right, B.right);

	    return num;

	}

}
