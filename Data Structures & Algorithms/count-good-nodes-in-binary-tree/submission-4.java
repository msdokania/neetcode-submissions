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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    public int dfs(TreeNode root, int maxval) {
        if(root==null)
            return 0;
        int ret = maxval>root.val? 0 : 1;
        maxval = Math.max(maxval, root.val);
        ret += dfs(root.left, maxval);
        ret += dfs(root.right, maxval);
        return ret;
    }
}
