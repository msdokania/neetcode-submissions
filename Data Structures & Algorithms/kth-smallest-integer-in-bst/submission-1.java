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
    int ans, i;
    public int kthSmallest(TreeNode root, int k) {
        ans = -1;
        i=0;
        dfs(root, k);
        return ans;
    }
    public void dfs(TreeNode root, int k) {
        if(root==null || i==k)
            return;
        dfs(root.left, k);
        i++;
        if(i==k) {
            ans = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
