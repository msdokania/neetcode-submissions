class Solution {
    int[][] dp;
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int total = 0, target = 0;
        for(int x : stones)
            total += x;
        target = (total+1)/2;
        dp = new int[n][target+1];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);
        return dfs(stones, 0, 0, target, total);
    }
    public int dfs(int[] stones, int i, int curr, int target, int total) {
        if(i==stones.length || curr>=target) {
            int pile2 = total-curr;
            return Math.abs(curr - pile2);
        }
        if(dp[i][curr] != -1)
            return dp[i][curr];
        dp[i][curr] = Math.min(dfs(stones, i+1, curr+stones[i], target, total), dfs(stones, i+1, curr, target, total));
        return dp[i][curr];
    }
}

