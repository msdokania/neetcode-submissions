class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(sum%2 != 0) return false;
        sum /= 2;
        dp = new Boolean[nums.length][sum+1];
        return helper(nums, 0, 0, sum);
    }
    public boolean helper(int[] nums, int i, int curr, int sum) {
        if(curr==sum) {
            return true;
        }
        if(curr>sum) {
            return false;
        }
        if(i==nums.length) return curr==sum;
        if(dp[i][curr]!=null) return dp[i][curr];
        dp[i][curr] = helper(nums, i+1, curr+nums[i], sum)|| helper(nums, i+1, curr, sum);
        return dp[i][curr];
    }
}
