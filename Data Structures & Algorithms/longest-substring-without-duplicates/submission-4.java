class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hs = new HashMap<>();
        int l=0, r=0;
        int ans = 0;
        while(r<s.length()) {
            if(l<=r && hs.containsKey(s.charAt(r)) && hs.get(s.charAt(r))>=l) {
                // hs.remove(s.charAt(l));
                l = hs.get(s.charAt(r)) + 1;
            }
            hs.put(s.charAt(r), r);
            r++;
            ans = Math.max(ans, r-l);
        }
        return ans;
    }
}
