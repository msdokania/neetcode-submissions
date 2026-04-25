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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(root.val > key) 
            root.left = deleteNode(root.left, key);
        else if(root.val < key) 
            root.right = deleteNode(root.right, key);
        else {
            if(root.left==null)
                return root.right;
            if(root.right==null)
                return root.left;
            TreeNode tmp = root.right;
            TreeNode prev = tmp;
            while(tmp.left!=null) {
                prev = tmp;
                tmp = tmp.left;
            }
            root.val = tmp.val;
            if(prev.val==tmp.val)
                root.right = tmp.right;
            else
                prev.left = null;
            // root.right = deleteNode(root.right, tmp.val);
        }
        return root;
    }
}