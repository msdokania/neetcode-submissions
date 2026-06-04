class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        Map<Character, Integer> hm = new HashMap<>();
        Map<Character, Integer> win = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i),0)+1);
        }
        int have = 0;
        int l=0, r=0;
        int minlen = Integer.MAX_VALUE;
        int[] ans = new int[]{0,0};
        while(l<=r && r<s.length()) {
            char c = s.charAt(r);
            win.put(c, win.getOrDefault(c,0)+1);
            if(hm.containsKey(c) && hm.get(c)==win.get(c)) {
                have++;
            }
            while(have==hm.size()) {
                if(minlen>r-l+1) {
                    minlen = r-l+1;
                    ans[0] = l;
                    ans[1] = r;
                }
                win.put(s.charAt(l), win.get(s.charAt(l))-1);
                if(hm.containsKey(s.charAt(l)) && hm.get(s.charAt(l)) == 1+win.get(s.charAt(l))) {
                    have--;
                }
                l++;
            }
            r++;
        }
        return minlen == Integer.MAX_VALUE? "" : s.substring(ans[0], ans[1]+1);
    }
}
