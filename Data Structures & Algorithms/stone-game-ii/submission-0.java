class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[2][n][n+1];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return helper(piles, 1, 0, 1, dp);
    }
    public int helper(int[] piles, int aliceturn, int i, int M, int[][][] dp) {
        if(i==piles.length) {
            return 0;
        }
        if(dp[aliceturn][i][M]!=-1) return dp[aliceturn][i][M];
        int sum = 0, alicescore = aliceturn==1? 0 : Integer.MAX_VALUE;
        for(int X=1; X<=2*M; X++) {
            int j = i+X-1;
            if(j>=piles.length) break;
            sum += piles[j];
            if(aliceturn==1)
                alicescore = Math.max(sum+helper(piles,0,j+1,Math.max(M,X),dp), alicescore);
            else
                alicescore = Math.min(helper(piles,1,j+1,Math.max(M,X),dp), alicescore);
        }
        dp[aliceturn][i][M] = alicescore;
        return dp[aliceturn][i][M];
    }
}