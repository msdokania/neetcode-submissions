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
        return count(root, root.val);
    }
    public int count(TreeNode root, int maxtillnow) {
        if(root==null) return 0;
        int ret = root.val >= maxtillnow? 1 : 0;
        maxtillnow = Math.max(root.val, maxtillnow);
        ret += count(root.left, maxtillnow);
        ret += count(root.right, maxtillnow);
        return ret;
    }
}
