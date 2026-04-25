class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[2];
        int maxlen = 1;
        for(int i=0; i<n; i++)
            dp[i][i] = true;
        for(int i=0; i<n-1; i++)
            if(s.charAt(i)==s.charAt(i+1)) {
                dp[i][i+1] = true;
                ans[0] = i;
                ans[1] = i+1;
                maxlen = 2;
            } 

        for(int len=3; len<=n; len++) {
            for(int i=0; i<n; i++) {
                int j = i+len-1;
                if(j<n && s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    if(j-i+1 > maxlen) {
                        ans[0] = i;
                        ans[1] = j;
                        maxlen = j-i+1;
                    }
                }
            }
        }
        return s.substring(ans[0], ans[1]+1);
    }
}
