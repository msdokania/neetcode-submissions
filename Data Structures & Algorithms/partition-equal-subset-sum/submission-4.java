class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums)
            sum+=x;
        if(sum%2!=0) return false;
        sum /= 2;
        boolean[][] dp = new boolean[nums.length][sum];
        return helper(nums, 0, 0, sum, dp);
    }
    public boolean helper(int[] nums, int i, int curr, int sum, boolean[][] dp) {
        if(curr==sum) {
            return true;
        }
        if(curr>sum || i==nums.length)
            return false;
        if(dp[i][curr])
            return dp[i][curr];
        dp[i][curr] = helper(nums, i+1, curr+nums[i], sum, dp) || helper(nums, i+1, curr, sum, dp);
        return dp[i][curr];
    }
}

