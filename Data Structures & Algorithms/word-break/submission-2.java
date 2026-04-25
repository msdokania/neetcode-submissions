class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<>();
        for(String x : wordDict)
            hs.add(x);
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        for(int i=s.length()-1; i>=0; i--) {
            for(String word : wordDict) {
                int len = word.length();
                if(s.length()-i >= len) {
                    String str = s.substring(i,i+len);
                    if(hs.contains(str) && dp[i+len]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}
