class Solution {
    int ans = 0;
    public int numDecodings(String s) {
        helper(s, 0);
        return ans;
    }
    public void helper(String s, int i) {
        if(i==s.length()) {
            ans++;
            return;
        }
        int sin = Integer.parseInt(s.substring(i,i+1));
        if(sin>0 && sin<=9)
            helper(s, i+1);
        if(i+1 < s.length() && (sin==1 || sin==2)) {
            int dbl = Integer.parseInt(s.substring(i,i+2));
            if(dbl>0 && dbl<=26) {
                helper(s, i+2);
            }
        }
    }
}


// 4523
// 1 + (1+0) + (1+0) + (1+1)
// 4   45