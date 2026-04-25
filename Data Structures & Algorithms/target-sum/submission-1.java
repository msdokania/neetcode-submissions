class Solution {
    int totalsum = 0;
    public int findTargetSumWays(int[] nums, int target) {
        for(int x : nums) totalsum+=x;
        int[][] dp = new int[nums.length][2*totalsum+1];
        for(int i=0; i<nums.length; i++)
            Arrays.fill(dp[i], -1);
        return helper(nums, target, 0, 0, dp);
    }
    public int helper(int[] nums, int target, int i, int curr, int[][] dp) {
        if(i==nums.length) {
            return curr==target? 1 : 0;
        }
        if(dp[i][curr+totalsum]!=-1) return dp[i][curr+totalsum];
        dp[i][curr+totalsum] = helper(nums,target,i+1,curr+nums[i],dp) + helper(nums,target,i+1,curr-nums[i],dp);
        return dp[i][curr+totalsum];
    }
}
