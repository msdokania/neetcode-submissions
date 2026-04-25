class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[2];
        int maxlen = 0;
        int ret = 0;
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(s.charAt(i) == s.charAt(j) && (j-i<=2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    ret++;
                    if(j-i+1 > maxlen) {
                        ans[0] = i;
                        ans[1] = j;
                        maxlen = j-i+1;
                    }
                }
            }
        }
        return ret;
    }
}
