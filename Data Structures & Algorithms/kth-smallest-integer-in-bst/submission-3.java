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
    // List<Integer> ans;
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        int ans = -1, i=0;
        TreeNode curr = root;
        while(!st.isEmpty()) {
            if(curr==null) {
                ans = st.peek().val;
                i++;
                if(i==k) return ans;
                curr = st.pop().right;
                continue;
            }
            st.push(curr);
            curr = curr.left;
        }
        return ans;
    }
    // public void dfs(TreeNode root, int k) {
    //     if(root==null || ans.size()==k) return;
    //     dfs(root.left, k);
    //     ans.add(root.val);
    //     if(ans.size()==k) return;
    //     dfs(root.right, k);
    // }
}


// 4, 3, 2

// push then go left
// as soon as left is null, pop and add in ans and inc idx
//     if right not null puh and go to its left



