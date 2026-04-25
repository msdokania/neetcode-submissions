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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return postorder(root, target, null);
    }
    public TreeNode postorder(TreeNode root, int target, TreeNode par) {
        if(root==null) return null;
        root.left = postorder(root.left,target,root);
        root.right = postorder(root.right,target,root);
        if(root.left==null && root.right==null && root.val==target) {
            return null;
        }
        return root;
    }
}






