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
    int idx = 0;
    Map<Integer, Integer> hm = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++)
            hm.put(inorder[i], i);
        return helper(preorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] preorder, int l, int r) {
        if(l>r) return null;
        TreeNode n = new TreeNode(preorder[idx++]);
        int x = hm.get(n.val);
        n.left = helper(preorder, l, x-1);
        n.right = helper(preorder, x+1, r);
        return n;
    }
}
