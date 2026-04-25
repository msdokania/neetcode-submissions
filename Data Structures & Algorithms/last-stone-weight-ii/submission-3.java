class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int total = 0, target = 0;
        for(int x : stones)
            total += x;
        target = (total+1)/2;
        int[][] dp = new int[n][target+1];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);
        return helper(stones, 0, 0, target, total, dp);
    }
    public int helper(int[] stones, int i, int curr, int target, int total, int[][] dp) {
        if(curr>=target || i==stones.length) {
            int pile2 = total-curr;
            return Math.abs(pile2-curr);
        }
        if(dp[i][curr]!=-1)
            return dp[i][curr];
        dp[i][curr] = Math.min(helper(stones,i+1,curr+stones[i],target,total,dp), helper(stones,i+1,curr,target,total,dp));
        return dp[i][curr];
    }
}