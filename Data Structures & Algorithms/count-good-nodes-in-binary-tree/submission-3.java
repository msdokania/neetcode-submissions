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
    int ans;
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        ans = 0;
        helper(root, -101);
        return ans;
    }
    public void helper(TreeNode root, int max) {
        if(root.val >= max)
            ans++;
        if(root.left!=null)
            helper(root.left, Math.max(root.val, max));
        if(root.right!=null)
            helper(root.right, Math.max(root.val, max));
    }
}
