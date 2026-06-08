class Solution {
    public String longestPalindrome(String s) {
        int maxlen = 1;
        int[] ans = {0,0};
        int n = s.length();
        for(int i=0; i<n; i++) {
            int l=i, r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)) {
                if(maxlen < r-l+1) {
                    maxlen = r-l+1;
                    ans[0] = l;
                    ans[1] = r;
                }
                l--;
                r++;
            }
        }
        for(int i=0; i<n; i++) {
            int l=i, r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)) {
                if(maxlen < r-l+1) {
                    maxlen = r-l+1;
                    ans[0] = l;
                    ans[1] = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(ans[0], ans[1]+1);
    }
}
