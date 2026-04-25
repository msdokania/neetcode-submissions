class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> countT = new HashMap<>();
        HashMap<Character, Integer> countS = new HashMap<>();
        for(char c : t.toCharArray())
            countT.put(c, countT.getOrDefault(c,0)+1);
        int have=0, need=countT.size(), l=0, r=0;
        int[] res = {-1,-1};
        int minLen = Integer.MAX_VALUE;
        for(r=0; r<s.length(); r++) {
            char c = s.charAt(r);
            countS.put(c, countS.getOrDefault(c,0)+1);
            if(countT.containsKey(c) && countT.get(c)==countS.get(c)) {
                have++;
            }
            while(l<=r && have==need) {
                if(r-l+1 < minLen) {
                    minLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }
                char cL = s.charAt(l);
                countS.put(cL, countS.getOrDefault(cL,0)-1);
                if(countT.containsKey(cL) && countT.get(cL)>countS.get(cL)) {
                    have--;
                }
                l++;
            }
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);
    }
}

