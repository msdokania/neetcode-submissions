class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return ans;
    }
    public void helper(int[] nums, int i, List<Integer> curr) {
        if(i>=nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        helper(nums, i+1, curr);
        curr.removeLast();
        helper(nums, i+1, curr);
    }
}
