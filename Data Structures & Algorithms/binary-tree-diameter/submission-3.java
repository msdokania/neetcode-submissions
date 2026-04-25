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
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        dia(root);
        return ans;
    }
    public int dia(TreeNode root) {
        if(root==null) return 0;
        int l = dia(root.left);
        int r = dia(root.right);
        ans = Math.max(ans, l+r);
        return 1+Math.max(l,r);
    }
}
