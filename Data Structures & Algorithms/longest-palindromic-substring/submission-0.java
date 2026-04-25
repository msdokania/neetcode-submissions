class Solution {
    public String longestPalindrome(String s) {
        int idx=0, len = 1;
        int n = s.length();
        for(int i=0; i<n; i++) {
            int l=i, r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)) {
                l--;
                r++;
            }
            if(r-l+1-2 > len) {
                len = r-l+1-2;
                idx = l+1;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)) {
                l--;
                r++;
            }
            if(r-l+1-2 > len) {
                len = r-l+1-2;
                idx = l+1;
            }
        }
        return s.substring(idx, idx+len);
    }
}
