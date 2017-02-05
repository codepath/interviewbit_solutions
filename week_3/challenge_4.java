// Path Sum with BFS
// https://www.interviewbit.com/problems/path-sum/

public class Solution {
	public boolean hasPathSum(TreeNode a, int b) {
	    if (a == null) {
	        return b == 0;
	    }
	    
	    if (a.left == null && a.right == null) {
	        return b - a.val == 0 ? 1 : 0;
	    }
	    
	    if (a.left == null) {
	        return  hasPathSum(a.right, b - a.val) == 1 ;
	    } else if (a.right == null) {
	         return hasPathSum(a.left, b - a.val) == 1 ;
	    } else {
	        return hasPathSum(a.left, b - a.val) == 1 || hasPathSum(a.right, b-a.val) == 1 ;
	    }
	   
	}
	
}
