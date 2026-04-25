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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode last = null;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size>0) {
                last = q.poll();
                if(last.left!=null) q.offer(last.left);
                if(last.right!=null) q.offer(last.right);
                size--;
            }
            if(last!=null) ans.add(last.val);
        }
        return ans;
    }
}
