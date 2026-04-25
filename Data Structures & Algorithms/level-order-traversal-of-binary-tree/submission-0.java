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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = q.size();
            while(size>0) {
                TreeNode n = q.poll();
                tmp.add(n.val);
                size--;
                if(n.left!=null) q.offer(n.left);
                if(n.right!=null) q.offer(n.right);
            }
            ans.add(tmp);
        }
        return ans;
    }
}
