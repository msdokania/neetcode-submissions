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
    List<Integer> postOrder;
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder = new ArrayList<>();
        postOrder(root);
        return postOrder;
    }
    public void postOrder(TreeNode root) {
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        postOrder.add(root.val);
    }
}

/*
LRN
Stack: 1, 2, 4

curr keeps moving to left unless null
as soon as null -> pop, curr to right
*/