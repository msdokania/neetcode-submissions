class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l=0, r=0, ans = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int curr = 0;
        while(r<n) {
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0)+1);
            curr = highestFreq(hm);
            while(l<=r && r-l+1 - curr > k) {
                hm.put(s.charAt(l), hm.get(s.charAt(l))-1);
                l++;
                // curr = highestFreq(hm);
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
    public int highestFreq(HashMap<Character, Integer> hm) {
        int max = 0;
        char ret = ' ';
        for(char c : hm.keySet()) {
            if(hm.get(c) > max) {
                ret = c;
                max = hm.get(c);
            }
        }
        return max;
    }
}

// PQ-
// A:1, B:2

// AAABABBBB

// k=1

// 3-2 <= k (false-> )
// ans = 5