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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode tmp = q.poll();
            TreeNode x = tmp.left;
            tmp.left = tmp.right;
            tmp.right = x;
            if(tmp.left!=null) q.offer(tmp.left);
            if(tmp.right!=null) q.offer(tmp.right);
        }
        return root;
    }
}
