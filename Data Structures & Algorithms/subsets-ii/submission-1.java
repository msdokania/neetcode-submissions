class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return ans;
    }
    public void helper(int[] nums, int i, List<Integer> curr) {
        if(i==nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        helper(nums, i+1, curr);
        curr.removeLast();
        while(i+1<nums.length && nums[i+1]==nums[i])
            i++;
        helper(nums, i+1, curr);
    }
}


// 1       []
// 12 1    2 []
// 121 12 11 1 21 2 1 []