class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        helper(nums, 0, 0, target, new ArrayList<>());
        return ans;
    }
    public void helper(int[] nums, int i, int currsum, int t, List<Integer> curr) {
        if(i==nums.length || currsum>t)
            return;
        if(currsum==t) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        helper(nums,i,currsum+nums[i],t,curr);
        curr.removeLast();
        helper(nums,i+1,currsum,t,curr);
    }
}
