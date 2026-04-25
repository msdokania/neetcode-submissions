class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums) sum+=x;
        if(sum%2!=0)
            return false;
        sum /= 2;
        boolean[][] dp = new boolean[n][sum+1];
        return helper(nums, dp, 0, 0, sum);
    }
    public boolean helper(int[] nums, boolean[][] dp, int i, int curr, int sum) {
        if(curr==sum) 
            return true;
        if(curr>sum || i==nums.length)
            return false;
        if(dp[i][curr]) 
            return true;
        dp[i][curr] = helper(nums, dp, i+1, curr+nums[i], sum) || helper(nums, dp, i+1, curr, sum);
        return dp[i][curr];
    }
}
