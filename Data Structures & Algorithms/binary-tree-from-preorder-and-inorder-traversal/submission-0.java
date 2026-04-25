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
    int i;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        i=0;
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] pre, int[] in, int l, int r) {
        if(l>r) return null;
        TreeNode curr = new TreeNode(pre[i]);
        int pos = findPos(in, pre[i]);
        i++;
        curr.left = helper(pre, in, l, pos-1);
        curr.right = helper(pre, in, pos+1, r);
        return curr;
    }
    public int findPos(int[] arr, int x) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == x) return i;
        }
        return -1;
    } 
}

/*
pre NLR -> 1,2,3,4
in LNR -> 2,1,3,4

1234, 2134, i=0, l=0,r=3 -> create node i++
    find pos of 1 in inorder = 1
    left = 234, 2, i=1, l=0, r=pos-1=0 -> create node i++
        pos = 0
        left = 34, x, i=2, l=0, r=-1 xx null
        right = 
    right = 34, 34, i=2, l=2,r=3  -> create node i++
        pos = 2
        left = 4, i=3, l=2, r=1 xx
        right = 4, 4, i=3, l=3, r=3 -->

*/






