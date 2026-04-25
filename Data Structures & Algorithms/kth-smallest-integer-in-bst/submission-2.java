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
    List<Integer> ans;
    public int kthSmallest(TreeNode root, int k) {
        ans = new ArrayList<>();
        dfs(root, k);
        return ans.get(k-1);
    }
    public void dfs(TreeNode root, int k) {
        if(root==null || ans.size()==k) return;
        dfs(root.left, k);
        ans.add(root.val);
        if(ans.size()==k) return;
        dfs(root.right, k);
    }
}
