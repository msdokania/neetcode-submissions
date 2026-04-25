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
        if(root==null) return postOrder;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()) {
            TreeNode tmp = st1.pop();
            st2.push(tmp);
            if(tmp.left != null) st1.push(tmp.left);
            if(tmp.right != null) st1.push(tmp.right);
        }
        while(!st2.isEmpty()) {
            postOrder.add(st2.pop().val);
        }
        return postOrder;
    }
    // public void postOrder(TreeNode root) {
    //     if(root==null) return;
    //     postOrder(root.left);
    //     postOrder(root.right);
    //     postOrder.add(root.val);
    // }
}

/*
LRN
Stack: 1, 2
curr = 2
4, 5
push & curr keeps moving to left unless null
as soon as null -> if top.right==null pop, process, cur=top; else curr = top.right
*/

// st1: 
// st2: 1, 3, 5, 2, 4






