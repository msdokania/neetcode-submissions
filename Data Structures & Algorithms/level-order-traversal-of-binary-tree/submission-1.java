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
            int len = q.size();
            List<Integer> lst = new ArrayList<>();
            while(len>0) {
                TreeNode tmp = q.poll();
                lst.add(tmp.val);
                if(tmp.left!=null) q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);
                len--;
            }
            ans.add(lst);
        }
        return ans;
    }
}
