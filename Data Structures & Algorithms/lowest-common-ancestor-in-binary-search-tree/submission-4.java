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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode tmp = st.pop();
            if(tmp.val==p.val || tmp.val==q.val)
                return tmp;
            if((tmp.val>p.val && tmp.val<q.val) || (tmp.val<p.val && tmp.val>q.val))
                return tmp;
            if(tmp.val<p.val && tmp.val<q.val)
                st.push(tmp.right);
            else 
                st.push(tmp.left);
        }
        return null;
    }
}
