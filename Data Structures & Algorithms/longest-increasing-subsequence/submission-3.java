class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=n-2; i>=0; i--) {
            for(int j=i+1; j<n; j++) {
                if(nums[j]>nums[i]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
}
