class Solution {
    public int countSubstrings(String s) {
        int ans=0;
        int n = s.length();
        for(int i=0; i<n; i++) {
            int l=i, r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)) {
                l--;
                r++;
                ans++;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)) {
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }
}
