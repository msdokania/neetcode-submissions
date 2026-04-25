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
        if(root==null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode tmp1 = q.poll();
            TreeNode tmp2 = tmp1.left;
            tmp1.left = tmp1.right;
            tmp1.right = tmp2;
            if(tmp1.left!=null) q.offer(tmp1.left);
            if(tmp1.right!=null) q.offer(tmp1.right);
        }
        return root;
    }
}
