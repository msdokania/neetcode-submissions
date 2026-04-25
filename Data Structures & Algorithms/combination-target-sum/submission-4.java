class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        helper(nums, 0, target, new ArrayList<>());
        return ans;
    }
    public void helper(int[] nums, int i, int target, List<Integer> curr) {
        if(target<0) return;
        if(target==0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i>=nums.length) return;
        curr.add(nums[i]);
        helper(nums, i, target-nums[i], curr);
        curr.removeLast();
        helper(nums, i+1, target, curr);
        // for(int j=i; j<nums.length; j++) {
        //     curr.add(nums[j]);
        //     helper(nums, j, target-nums[j], curr);
        //     curr.removeLast();
        // }
    }
}
