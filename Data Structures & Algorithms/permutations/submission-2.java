class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, new ArrayList<>(), visited);
        return ans;
    }
    public void helper(int[] nums, List<Integer> curr, boolean[] vis) {
        if(curr.size()>=nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int j=0; j<nums.length; j++) {
            if(!vis[j]) {
                curr.add(nums[j]);
                vis[j] = true;
                helper(nums, curr, vis);
                curr.removeLast();
                vis[j] = false;
            }
        }
    }
}
