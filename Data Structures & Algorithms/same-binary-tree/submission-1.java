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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null || p.val!=q.val) 
            return false;
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.offer(p);
        qQueue.offer(q);
        while(!pQueue.isEmpty() && !qQueue.isEmpty()) {
            int size = pQueue.size();
            while(size>0) {
                TreeNode tmp1 = pQueue.poll();
                TreeNode tmp2 = qQueue.poll();
                if(tmp1==null && tmp2==null) {
                    size--;
                    continue;
                }
                 if(tmp1==null || tmp2==null || tmp1.val != tmp2.val)  
                    return false;
                pQueue.offer(tmp1.left); 
                pQueue.offer(tmp1.right);
                qQueue.offer(tmp2.left);
                qQueue.offer(tmp2.right);
                size--;
            }
        }
        if(!pQueue.isEmpty() || !qQueue.isEmpty())
            return false;
        return true;
    }
}
