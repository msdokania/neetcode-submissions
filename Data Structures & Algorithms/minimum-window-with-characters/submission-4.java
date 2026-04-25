class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> sfreq = new HashMap<>();
        Map<Character, Integer> tfreq = new HashMap<>();
        int matches = 0;
        for(char c : t.toCharArray())
            tfreq.put(c, tfreq.getOrDefault(c,0)+1);
        int need = tfreq.size();
        int l=0, r=0;
        int minlen = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while(l<=r && r<s.length()) {
            char c = s.charAt(r);
            sfreq.put(c, sfreq.getOrDefault(c,0)+1);
            if(tfreq.containsKey(c) && sfreq.get(c)==tfreq.get(c)) {
                matches++;
            }
            while(matches==need) {
                if(minlen>r-l+1) {
                    minlen = r-l+1;
                    ans[0] = l;
                    ans[1] = r;
                }
                char cl = s.charAt(l);
                sfreq.put(cl, sfreq.get(cl)-1);
                l++;
                if(tfreq.containsKey(cl) && sfreq.get(cl)+1==tfreq.get(cl)) {
                    matches--;
                }
            }
            r++;
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(ans[0],ans[1]+1);
    }
}
