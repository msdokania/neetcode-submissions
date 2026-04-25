class Solution {
    int[] freq;
    public int characterReplacement(String s, int k) {
        freq = new int[26];
        int l=0, ans=0;
        for(int r=0; r<s.length(); r++) {
            freq[s.charAt(r)-'A']++;
            if(l<r && !isValid(k)) {
                freq[s.charAt(l)-'A']--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
    public boolean isValid(int k) {
        int mostFreq = 0, sum=0;
        for(int i=0; i<26; i++) {
            if(freq[i] > mostFreq) {
                mostFreq = freq[i];
            }
            sum += freq[i];
        }
        return (sum-mostFreq)<=k;
    }
}


// AAABABBBB
// 012345678

// l=2
// r=8

// isValid() -> other count than most freq shoud be <= k