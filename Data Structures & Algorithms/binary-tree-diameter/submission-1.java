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
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        dia(root);
        return max;
    }
    public int dia(TreeNode node) {
        if(node==null) return 0;
        int l = dia(node.left);
        int r = dia(node.right);
        max = Math.max(max, l+r);
        return 1+Math.max(l,r);
    }
}
