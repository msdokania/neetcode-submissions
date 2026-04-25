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
        int[] ans = helper(root);
        return ans[0]==1? true : false;
    }
    public int[] helper(TreeNode root) {
        if(root==null) return new int[]{1,0};
        int[] l = helper(root.left);
        int[] r = helper(root.right);
        int x = Math.max(l[1],r[1]);
        int flag = 0;
        if(Math.abs(l[1]-r[1])>1 || l[0]==0 || r[0]==0)
            return new int[]{0, 1+x};
        return new int[]{1, 1+x};
    }
}
