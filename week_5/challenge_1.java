// Level order
// https://www.interviewbit.com/problems/level-order/
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if (A == null) {
            return res;
        }

        ArrayList<Integer> level = new ArrayList<Integer>();
        Queue<TreeNode> qCurrLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> qNextLevel = new LinkedList<TreeNode>();
        qCurrLevel.add(A);

        while (!qCurrLevel.isEmpty()) {

            TreeNode node = qCurrLevel.remove();

            if (node.left != null) {
                qNextLevel.add(node.left);
            }

            if (node.right != null) {
                qNextLevel.add(node.right);
            }

            level.add(node.val);
            if (qCurrLevel.isEmpty()) {
                qCurrLevel = qNextLevel;
                qNextLevel = new LinkedList<TreeNode>();
                res.add(level);
                level = new ArrayList<Integer>();
            }
        }

        return res;
    }
}
