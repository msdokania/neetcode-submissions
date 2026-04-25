class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(char c : s.toCharArray())
            freq[c-'a']++;
        int maxidx = 0;
        for(int i=0; i<26; i++) {
            if(freq[i] > freq[maxidx]) {
                maxidx = i;
            }
        }
        if(freq[maxidx] > (n+1)/2) return "";
        char[] ans = new char[n];
        int idx = 0;
        char c = (char)(maxidx+'a');
        while(freq[maxidx]>0) {
            ans[idx] = c;
            freq[maxidx]--;
            idx += 2;
        }
        for(int i=0; i<26; i++) {
            c = (char)(i+'a');
            while(freq[i] > 0) {
                if(idx>=n) idx=1;
                ans[idx] = c;
                idx += 2;
                freq[i]--;
            }
        }
        return new String(ans);
    }
}







