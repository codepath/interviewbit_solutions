// Identify Binary Search Trees
// https://www.interviewbit.com/problems/valid-binary-search-tree/
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
	public int isValidBST(TreeNode A) {

	    if (A == null)
	        return 0;

	    ArrayList<Integer> inorder = new ArrayList<>();
	    Stack<TreeNode> stack = new Stack<>();

	    TreeNode node = A;
	    addNodes(node, stack);

	    while (!stack.isEmpty()) {
	        node = stack.pop();
	        inorder.add(node.val);
	        node = node.right;
	        addNodes(node, stack);
	    }

	    for (int i = 1; i < inorder.size(); i++) {
	        int val = inorder.get(i);
	        int prev = inorder.get(i - 1);
	        if (val <= prev)
	            return 0;
	    }

	    return 1;

	}

	private void addNodes(TreeNode node, Stack<TreeNode> stack) {
	    while (node != null) {
	        stack.push(node);
	        node = node.left;
	    }
	}


}
