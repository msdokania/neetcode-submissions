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
    // List<Integer> inOrder;
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        if(root==null) return inOrder;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(!st.isEmpty() || curr!=null) {
            while(curr!=null) {
                st.push(curr);
                curr = curr.left;
            }
            TreeNode tmp = st.pop();
            inOrder.add(tmp.val);
            curr = tmp.right;
        }
        return inOrder;
    }
    // public void inOrder(TreeNode root) {
    //     if(root==null) return;
    //     inOrder(root.left);
    //     inOrder.add(root.val);
    //     inOrder(root.right);
    // }
}