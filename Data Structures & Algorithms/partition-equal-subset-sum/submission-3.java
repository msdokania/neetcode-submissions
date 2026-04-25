class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(sum%2!=0) return false;
        sum /= 2;
        boolean[][] dp = new boolean[n][sum+1];
        return helper(nums, 0, 0, sum, dp);
    }
    public boolean helper(int[] nums, int i, int curr, int sum, boolean[][] dp) {
        if(curr==sum) {
            return true;
        }
        if(i==nums.length || curr>sum)
            return false;
        if(dp[i][curr])
            return true;
        dp[i][curr] = helper(nums,i+1,curr+nums[i],sum,dp) ||
                        helper(nums,i+1,curr,sum,dp);
        return dp[i][curr];
    }
}
