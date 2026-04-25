class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        helper(new LinkedList<>(), 0, target, nums);
        return ans;
    }
    public void helper(LinkedList<Integer> curr, int i, int target, int[] nums) {
        if(i==nums.length || target<0)
            return;
        if(target==0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        helper(curr, i, target-nums[i], nums);
        curr.removeLast();
        helper(curr, i+1, target, nums);
    }
}
