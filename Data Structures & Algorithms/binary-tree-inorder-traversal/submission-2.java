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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        TreeNode curr = root;
        while(!st.isEmpty() || curr!=null) {
            while(curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            TreeNode tmp = st.pop();
            ans.add(tmp.val);
            curr = tmp.right;
        }
        return ans;
    }
}