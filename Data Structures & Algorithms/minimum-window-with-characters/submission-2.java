class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for(char c : t.toCharArray())
            tMap.put(c, tMap.getOrDefault(c,0)+1);
        int l=0, match=0, need=tMap.size(), len=Integer.MAX_VALUE;
        int[] ans = new int[2];
        for(int r=0; r<s.length(); r++) {
            char c = s.charAt(r);
            if(tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c,0)+1);
                if(sMap.get(c)==tMap.get(c))
                    match++;
            }
            while(l<=r && match==need) {
                if(r-l+1 < len) {
                    ans[0] = l;
                    ans[1] = r;
                    len = ans[1]-ans[0]+1;
                }
                char cl = s.charAt(l);
                if(sMap.containsKey(cl) && sMap.get(cl)>0) {
                    sMap.put(cl, sMap.get(cl)-1);
                    if(sMap.get(cl)<tMap.get(cl))
                        match--;
                }
                l++;
            }
        }
        if(len==Integer.MAX_VALUE) return "";
        return s.substring(ans[0], ans[1]+1);
    }
}
