class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        for(int i=n-1; i>=0; i--) {
            for(String word : wordDict) {
                int len = word.length();
                if(n-i < len) continue;
                if(s.substring(i, i+len).equals(word) && dp[i+len]) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }
}
