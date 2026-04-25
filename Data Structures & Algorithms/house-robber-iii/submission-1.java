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
    public int rob(TreeNode root) {
        int[] profit = dfs(root);
        return Math.max(profit[0],profit[1]);
    }
    public int[] dfs(TreeNode root) {
        if(root==null) return new int[]{0,0};
        int[] profitLeft = dfs(root.left);
        int[] profitRight = dfs(root.right);
        int take = root.val + profitLeft[1] + profitRight[1];
        int nottake = Math.max(profitLeft[0],profitLeft[1]) + Math.max(profitRight[0],profitRight[1]);
        return new int[]{take,nottake};
    }
    // public int helper(TreeNode root, boolean rob, int profit) {
    //     if(root==null) return 0;
    //     if(rob) {
    //         profit += root.val;
    //         ans = Math.max(ans, profit);
    //         return root.val + helper(root.left, false, profit) + helper(root.right, false, profit);
    //     }
    //     else {
    //         int left = Math.max(helper(root.left,true,profit), helper(root.left,false,profit));
    //         int right = Math.max(helper(root.right,true,left+profit), helper(root.right,false,left+profit));
    //         return left + right;
    //     }
    // }
}

// ans = 1
// (1,0,0)->(4,1,0)&(x,1,0)
// (1,1,0)->(4,0,1)&(x) -> ()
