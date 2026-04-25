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
    public String serialize(TreeNode node) {
        if(node==null)
            return "$#";
        return "$" + node.val + serialize(node.left) + serialize(node.right);
    }
    public int[] zarray(String s) {
        int n  = s.length();
        int[] z = new int[n];
        int l=0, r=0;
        for(int i=1; i<n; i++) {
            if(i<=r) {
                z[i] = z[i-l];
                // z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while(i+z[i] < n && s.charAt(z[i])==s.charAt(i+z[i]))
                z[i]++;
            if(i+z[i]-1 > r) {
                l=i;
                r=i+z[i]-1;
            }
        }
        return z;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String r = serialize(root);
        String sub = serialize(subRoot);
        String combined = sub + "|" + r;
        int[] z = zarray(combined);
        int len = sub.length();
        for(int i=len+1; i<combined.length(); i++) {
            if(z[i] == len)
                return true;
        }
        return false;
    }
}





