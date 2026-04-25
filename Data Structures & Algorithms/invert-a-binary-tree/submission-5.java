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
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode tmp = st.pop();
            TreeNode tmp2 = tmp.left;
            tmp.left = tmp.right;
            tmp.right = tmp2;
            if(tmp.left!=null) st.push(tmp.left);
            if(tmp.right!=null) st.push(tmp.right);
        }
        return root;
    }
}
