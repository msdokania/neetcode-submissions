class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int l=0, ans = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int r=0; r<s.length(); r++) {
            char c = s.charAt(r);
            if(hm.containsKey(c) && hm.get(c)>=l) {
                l = Math.min(r, hm.get(c)+1);
            }
            hm.put(c, r);
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}
