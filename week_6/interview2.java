public class Interview2 {
 	/**
		Traverse the binary tree in pre-order.  The solution is a bottom to top solution. Since you want the max path from any two nodes,
		you want to keep track of the max path at any time.  You can do this with a global variable.  

		Steps:
		1) Pre Order traversal
		2) When you hit a leaf node, you return the value.  This is because it's the max value at the time.
		3) You also compare the totalMax to the value of the right max subtree + the left max subtree + the root value node.  You will set totalMax to the biggest value.  
		   Note: Because the path can start at any node and end at any node, if the right and left subtree max is < 0, don't include it.
		Example: 
		              4
		    -100            6
		  1     3        5      0 
		  
		  Node:  What max value is returned for the subtree,  and the final max is
		  1: Max = 1, Final Max = 1
	      3: Max = 3, Final Max (1,3) = 3
	      -100: Max = 3+-100 = -97   final Max ( 3, 3+1+-100) = 3
	      5: Max = 5, Final (3,5) = 5
	      0: Max = 0, Final (0,5) = 5
	      6: Max ( 5, 0) + 6 = 11  final Max( 5, 5+0+6) = 11
	      4: Max (11, -97) + 4 = 11 + 4     final Max ( 11, (ignore -100) + 11+4) = 15
      	
      	Solution: 15
	
			Runtime: O(n) 
			Space: O(h) h is the hight of the tree and this is for the recursive stack
 	**/
 	private int totalMax = Integer.MIN_VALUE;
          
  	public int maxPathSum(TreeNode root) {
      int val = helper(root);
      return totalMax;
  	}
 
	public int helper(TreeNode root) {
		if(root == null) {
		  return 0;
		}

		int left = helper(root.left);
		int right = helper(root.right);

		// Since it can be from any node, if it's negative ignore
		if(left < 0) {
		  left = 0;
		}

		if(right < 0) {
		  right = 0;
		}

		// determine what the max total is
		totalMax = Math.max(totalMax, left + right + root.val);

		// return the max value up the tree
		return Math.max(left, right) + root.val;
	}
}