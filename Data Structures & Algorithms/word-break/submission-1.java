class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        int i=0;
        while(i<s.length()) {
            for(String word : wordDict) {
                if(n < i+ word.length()) continue;
                if(s.substring(i, i+word.length()).equals(word)) {
                    dp[i+word.length()] |= dp[i];
                }
            }
            i++;
        }
        return dp[n];
    }
    // public boolean helper(String s, List<String> wordDict, Set<String> hs, int i) {
    //     if(i==s.length())
    //         return true;
    //     if()
    // }
}

