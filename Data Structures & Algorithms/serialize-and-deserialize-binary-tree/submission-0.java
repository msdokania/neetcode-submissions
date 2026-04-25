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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int x = q.size();
            while(x>0) {
                TreeNode t = q.poll();
                if(t==null) {
                    sb.append("#$");
                }
                else {
                    sb.append(t.val);
                    sb.append("$");
                    q.offer(t.left);
                    q.offer(t.right);
                }
                x--;
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split("\\$");
        if(nodes[0].equals("#")) return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);
        int idx = 1;
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(!nodes[idx].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[idx]));
                q.offer(curr.left);
            }
            idx++;
            if(!nodes[idx].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[idx]));
                q.offer(curr.right);
            }
            idx++;
        }
        return root;
    }
}
