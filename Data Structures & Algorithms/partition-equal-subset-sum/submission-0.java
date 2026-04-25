class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(sum%2 != 0)
            return false;
        return helper(nums, sum/2, 0, 0);
    }
    public boolean helper(int[] nums, int sum, int curr, int i) {
        if(curr==sum)
            return true;
        if(i>=nums.length || curr>sum)
            return false;
        boolean x = helper(nums, sum, curr+nums[i], i+1);
        if(x) return true;
        boolean y = helper(nums, sum, curr, i+1);
        return x||y;
    }
}
