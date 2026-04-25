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
    List<Integer> preOrder;
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder = new ArrayList<>();
        if(root==null) return preOrder;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        st.push(root);
        while(!st.isEmpty()) {
            curr = st.pop();
            preOrder.add(curr.val);
            if(curr.right != null) st.push(curr.right);
            if(curr.left != null) st.push(curr.left);
        }
        return preOrder;
    }
    // public void preOrder(TreeNode root) {
    //     if(root==null) return;
    //     preOrder.add(root.val);
    //     preOrder(root.left);
    //     preOrder(root.right);
    // }
}



// // NLR
// curr = 3
// ans = 1, 2, 4, 5, 3
// 7, 6







