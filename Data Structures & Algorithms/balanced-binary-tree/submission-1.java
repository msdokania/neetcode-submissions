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
    public boolean isBalanced(TreeNode root) {
        int[] ans = new int[2];
        ans = bal(root);
        return ans[1]==0? false : true;
    }
    public int[] bal(TreeNode root) {
        if(root==null) {
            return new int[]{0,1};
        }
        int[] l = bal(root.left);
        int[] r = bal(root.right);
        if(Math.abs(l[0] - r[0]) > 1 || l[1]==0 || r[1]==0)
            return new int[]{0,0};
        return new int[]{1+Math.max(l[0],r[0]), 1};
    }
}
