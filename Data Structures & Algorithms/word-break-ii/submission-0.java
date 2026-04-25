class Solution {
    List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        Set<String> hs = new HashSet<>(wordDict);
        helper(s, 0, hs, new ArrayList<>());
        return ans;
    }
    public void helper(String s, int i, Set<String> hs, List<String> curr) {
        if(i==s.length()) {
            StringBuilder sb = new StringBuilder();
            for(String x : curr) {
                sb.append(x);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            ans.add(sb.toString());
            return;
        }
        for(int j=i; j<s.length(); j++) {
            String x = s.substring(i, j+1);
            if(hs.contains(x)) {
                curr.add(x);
                helper(s, j+1, hs, curr);
                curr.removeLast();
            }
        }
    }
}