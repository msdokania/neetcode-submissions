class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=1; i<n; i++) {
            int x = Integer.parseInt(s.substring(i-1, i+1));
            int single = s.charAt(i)=='0'? 0 : dp[i];
            int dbl = s.charAt(i-1)=='0' || x>26 ? 0 : i==1? 1 : dp[i-1];
            dp[i+1] = single+dbl;
        }
        return dp[n];
    }
}
