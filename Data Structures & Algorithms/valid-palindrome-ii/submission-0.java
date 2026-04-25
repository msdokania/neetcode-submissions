class Solution {
    public boolean validPalindrome(String s) {
        return helper(s,0,s.length()-1, false);
    }
    public boolean helper(String s, int l, int r, boolean delete) {
        if(l>r) return false;
        while(l<r) {
            if(s.charAt(l)!=s.charAt(r)) {
                if(delete) return false;
                return helper(s,l+1,r,true) || helper(s,l,r-1,true);
            }
            l++;
            r--;
        }
        return true;
    }
}