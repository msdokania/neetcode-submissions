class Solution {
    Set<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new HashSet<>();
        backtrack(nums, target, 0, new ArrayList<>(), 0);
        return new ArrayList<>(ans);
    }
    public void backtrack(int[] nums, int t, int i, List<Integer> curr, int currSum) {
        if(currSum==t) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(currSum>t || i==nums.length) return;
        curr.add(nums[i]);
        backtrack(nums, t, i, curr, currSum+nums[i]);
        curr.removeLast();
        backtrack(nums, t, i+1, curr, currSum);
        // for(int j=0; j<nums.length; j++) {
        //     curr.add(nums[j]);
        //     backtrack(nums, t, curr, currSum+nums[j]);
        //     curr.removeLast();
        // }
    }
}

// curr=2
// currSum=0
//     curr=2
//     currSum=2
