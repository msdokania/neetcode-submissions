class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = {0,0};
        int maxlen = 1;
        for(int i=n-2; i>=0; i--) {
            for(int j=i+1; j<n; j++) {
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if(maxlen < j-i+1) {
                        maxlen = j-i+1;
                        ans[0] = i;
                        ans[1] = j;
                    }
                }
            }
        }
        return s.substring(ans[0], ans[1]+1);
    }
}


