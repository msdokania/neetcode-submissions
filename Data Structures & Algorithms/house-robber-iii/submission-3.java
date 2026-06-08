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
    public int rob(TreeNode root) {
        int[] ans = helper(root);
        return Math.max(ans[0],ans[1]);
    }
    public int[] helper(TreeNode root) {
        if(root==null) return new int[]{0,0};
        int[] l = helper(root.left);
        int[] r = helper(root.right);
        int rob = root.val + l[1] + r[1];
        int notrob = Math.max(l[0],l[1]) + Math.max(r[0],r[1]);
        return new int[]{rob, notrob};
    }
}