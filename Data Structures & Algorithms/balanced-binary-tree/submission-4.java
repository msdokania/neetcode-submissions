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
        int[] ans = dia(root);
        return ans[1]==0? false : true;
    }
    public int[] dia(TreeNode root) {
        if(root==null) return new int[]{0,1};
        int[] l = dia(root.left);
        int[] r = dia(root.right);
        if(l[1]==0 || r[1]==0 || Math.abs(l[0]-r[0])>1)
            return new int[]{0,0};
        return new int[]{1+Math.max(l[0],r[0]), 1};
    }
}
