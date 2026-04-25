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
    int ans;
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        ans = 0;
        dfs(root, -101);
        return ans;
    }
    public void dfs(TreeNode root, int x) {
        if(root.val >= x)
            ans++;
        if(root.left!=null) dfs(root.left, Math.max(x, root.val));
        if(root.right!=null) dfs(root.right, Math.max(x, root.val));
    }
}
