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
        if(root==null) return null;
        TreeNode curr = root;
        TreeNode parent = null;
        while(curr!=null && curr.val!=key) {
            parent = curr;
            if(key<curr.val)
                curr = curr.left;
            else
                curr = curr.right;
        }
        if(curr==null) return root;
        TreeNode tmp = curr.left==null? curr.right : curr.left;
        if(curr.left==null || curr.right==null) {
            if(parent==null) return tmp;
            if(parent.left==curr) {
                parent.left = tmp;
                return root;
            } else {
                parent.right = tmp;
                return root;
            }
        }

        // If 2 children
        tmp = curr;
        curr = curr.right;
        TreeNode par = null;
        while(curr.left!=null) {
            par = curr;
            curr = curr.left;
        }
        tmp.val = curr.val;
        if(par==null) {
            tmp.right = curr.right;
        } else {
            par.left = curr.right;
        }
        if(parent==null) return tmp;
        return root;
    }
}






