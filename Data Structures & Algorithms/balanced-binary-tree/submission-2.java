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
        if(root==null) return true;
        int[] ans = height(root);
        return ans[0]==0 ? false : true;
    }
    public int[] height(TreeNode root) {
        if(root==null) return new int[]{1,0};
        int[] l = height(root.left);
        int[] r = height(root.right);
        if(l[0]==0 || r[0]==0 || Math.abs(l[1]-r[1])>1)
            return new int[]{0,0};
        return new int[]{1, 1+ Math.max(l[1],r[1])};
    }
}
