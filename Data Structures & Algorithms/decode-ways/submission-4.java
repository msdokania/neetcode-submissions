class Solution {
    int ans = 0;
    public int numDecodings(String s) {
        int prevprev = 1, prev = s.charAt(0)=='0'? 0 : 1;
        for(int i=1; i<s.length(); i++) {
            int sin = (s.charAt(i)-'0')==0? 0 : prev;
            int x = Integer.parseInt(s.substring(i-1,i+1));
            int dbl = (s.charAt(i-1)=='0'? 0 : x>26? 0 : prevprev);
            prevprev = prev;
            prev = sin+dbl;
        }
        return prev;
    }
}


// 4523
// 1 + (1+0) + (1+0) + (1+1)
// 4   45