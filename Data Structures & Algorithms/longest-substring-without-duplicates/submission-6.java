class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        int l=0, r=0, ans = 0;
        while(r<s.length()) {
            char c = s.charAt(r);
            if(hm.containsKey(c) && hm.get(c)>=l) {
                l = hm.get(c)+1;
            }
            hm.put(c,r);
            r++;
            ans = Math.max(ans, r-l);
        }
        return ans;
    }
}
