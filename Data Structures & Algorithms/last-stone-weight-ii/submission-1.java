class Solution {
    int total;
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        total = 0;
        int target = 0;
        for(int x : stones)
            total += x;
        target = (total+1)/2;
        int[][] dp = new int[n][target+1];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);
        return helper(stones, 0, 0, target, dp);
    }
    public int helper(int[] stones, int i, int currsum, int target, int[][] dp) {
        if(i>=stones.length || currsum>=target) {
            return Math.abs(total - 2*currsum);
        }
        if(dp[i][currsum] != -1)
            return dp[i][currsum];
        dp[i][currsum] = Math.min(helper(stones, i+1, currsum+stones[i], target, dp), 
                                helper(stones, i+1, currsum, target, dp));
        return dp[i][currsum];
    }
}





