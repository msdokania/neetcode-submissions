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
    public int goodNodes(TreeNode root) {
        int ans = 0;
        if(root==null) return ans;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<TreeNode, Integer>(root, root.val));
        while(!q.isEmpty()) {
            int size = q.size();
            while(size>0) {
                Pair<TreeNode, Integer> p = q.poll();
                if(p.getKey().val >= p.getValue()) 
                    ans++;
                int x = Math.max(p.getValue(), p.getKey().val);
                if(p.getKey().left != null)
                    q.offer(new Pair<TreeNode, Integer>(p.getKey().left, x));
                if(p.getKey().right != null)
                    q.offer(new Pair<TreeNode, Integer>(p.getKey().right, x));
                size--;
            }
        }
        return ans;
    }
}
