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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        Queue<Pair<TreeNode, int[]>> q = new LinkedList<>();
        q.offer(new Pair<TreeNode, int[]>(root, new int[]{-1000,1000}));
        while(!q.isEmpty()) {
            int size = q.size();
            while(size>0) {
                Pair<TreeNode, int[]> p = q.poll();
                TreeNode n = p.getKey();
                int[] tmp = p.getValue();
                if(n.val <= tmp[0] || n.val >= tmp[1])
                    return false;
                if(n.left!=null)
                    q.offer(new Pair<TreeNode, int[]>(n.left, new int[]{tmp[0],n.val}));
                if(n.right!=null)
                    q.offer(new Pair<TreeNode, int[]>(n.right, new int[]{n.val,tmp[1]}));
                size--;
            }
        }
        return true;
        // return dfs(root, -1000, 1000);
    }
    // public boolean dfs(TreeNode root, int min, int max) {
    //     if(root==null) return true;
    //     if(root.val<=min || root.val>=max)
    //         return false;
    //     return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    // }
}
