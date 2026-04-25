class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, r=0;
        int[] freq = new int[26];
        Character max = s.charAt(0);
        int maxfreq = 0;
        int ans = 0;
        while(r<s.length()) {
            char c = s.charAt(r);
            freq[c-'A']++;
            maxfreq = calcmax(freq);
            while(l<r && r-l+1-maxfreq > k) {
                freq[s.charAt(l)-'A']--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
    public int calcmax(int[] freq) {
        int ret = 0;
        for(int i=0; i<26; i++) {
            ret = Math.max(ret, freq[i]);
        }
        return ret;
    }
}
