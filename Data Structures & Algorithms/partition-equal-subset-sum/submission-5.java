class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(sum%2 != 0) return false;
        sum /= 2;
        return helper(nums, 0, 0, sum);
    }
    public boolean helper(int[] nums, int i, int curr, int sum) {
        if(curr==sum) {
            return true;
        }
        if(i==nums.length) return false;
        boolean x = helper(nums, i+1, curr+nums[i], sum);
        if(x) return true;
        return helper(nums, i+1, curr, sum);
    }
}
