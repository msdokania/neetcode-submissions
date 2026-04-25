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
 */ // LRN
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        TreeNode curr = root;
        while(!st.isEmpty() || curr!=null) {
            if(curr!=null) {
                ans.add(curr.val);
                st.push(curr);
                curr = curr.right;
            }
            else {
                TreeNode tmp = st.pop();
                curr = tmp.left;
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
