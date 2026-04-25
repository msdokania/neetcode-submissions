class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums)
            sum+=x;
        if(sum%2!=0) return false;
        sum /= 2;
        boolean[][] dp = new boolean[n][sum+1];
        return helper(nums, dp, 0, sum);
    }
    public boolean helper(int[] nums, boolean[][] dp, int i, int sum){
        if(sum==0) return true;
        if(i>=nums.length || sum<0) return false;
        dp[i][sum] = helper(nums, dp, i+1, sum-nums[i]) || helper(nums, dp, i+1, sum);
        return dp[i][sum];
    }
}
