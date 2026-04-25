/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int max = 0;
    public int maxDepth(TreeNode root) {
        helperMax(0, root);
        return max;
    }
    public void helperMax(int curDepth, TreeNode node) {
        max = Math.max(max, curDepth);
        if(node==null) {
            return;
        }
        helperMax(curDepth+1, node.left);
        helperMax(curDepth+1, node.right);
    }
}
