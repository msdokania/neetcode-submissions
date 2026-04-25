class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        helper(nums, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }
    public void helper(int[] nums, List<Integer> curr, boolean[] visited) {
        if(curr.size()==nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(visited[i]) continue;
            curr.add(nums[i]);
            visited[i] = true;
            helper(nums, curr, visited);
            visited[i] = false;
            curr.removeLast();
        }
    }
}
