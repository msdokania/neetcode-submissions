class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        helper(candidates, 0, 0, target, new ArrayList<>());
        return ans;
    }
    public void helper(int[] nums, int i, int currsum, int t, List<Integer> curr) {
        if(currsum==t) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i==nums.length || currsum>t)
            return;
        curr.add(nums[i]);
        helper(nums,i+1,currsum+nums[i],t,curr);
        while(i<nums.length-1 && nums[i+1]==nums[i])
            i++;
        curr.removeLast();
        helper(nums,i+1,currsum,t,curr);
    }
}

