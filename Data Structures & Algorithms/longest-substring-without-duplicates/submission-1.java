class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int l=0, r=0;
        int ans = 0;
        while(r<s.length()) {
            while(l<=r && hs.contains(s.charAt(r))) {
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(s.charAt(r));
            r++;
            ans = Math.max(ans, r-l);
        }
        return ans;
    }
}
