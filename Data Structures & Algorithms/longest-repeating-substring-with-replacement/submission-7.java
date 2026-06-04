class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        Character maxchar = '.';
        int maxlen = 0;
        Map<Character, Integer> count = new HashMap<>();
        int l=0, r=0;
        while(l<=r && r<s.length()) {
            char c = s.charAt(r);
            count.put(c, count.getOrDefault(c,0)+1);
            if(count.get(c) > maxlen) {
                maxlen = count.get(c);
                maxchar = c;
            }
            if(r-l+1 - maxlen > k) {
                count.put(s.charAt(l), count.get(s.charAt(l))-1);
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}
