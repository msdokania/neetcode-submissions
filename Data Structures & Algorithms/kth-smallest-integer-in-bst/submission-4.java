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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        int i=0;
        TreeNode curr = root;
        while(!st.isEmpty() || curr!=null) {
            while(curr!=null) {
                st.push(curr);
                curr = curr.left;
            }
            TreeNode tmp = st.pop();
            curr = tmp.right;
            i++;
            if(i==k) return tmp.val;
        }
        return -1;
    }
}
