class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int matches = 0;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i=0; i<s1.length(); i++) {
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++) {
            if(freq1[i]==freq2[i]) matches++;
        }
        if(matches==26) return true;
        int start = 0;
        for(int i=s1.length(); i<s2.length(); i++) {
            if(matches==26) return true;
            int x = s2.charAt(i)-'a';
            freq2[x]++;
            if(freq2[x]==freq1[x]) matches++;
            else if(freq2[x]==freq1[x]+1) matches--;
            x = s2.charAt(start)-'a';
            freq2[x]--;
            start++;
            if(freq2[x]==freq1[x]) 
                matches++;
            else if(freq2[x]==freq1[x]-1) 
                matches--;
            
            
            if(matches==26) return true;
            // String code_s2 = getHash(s2, i, s1.length());
            // if(code_s1.equals(code_s2))
            //     return true;
        }
        return matches==26;
    }
    // public String getHash(String s) {
    //     int[] freq = new int[26];
    //     StringBuilder sb = new StringBuilder();
    //     for(char c : s.toCharArray())
    //         freq[c-'a']++;
    //     for(int i=0; i<26; i++) {
    //         sb.append(freq[i]);
    //         sb.append('#');
    //     }
    //     return sb.toString();
    // }
}


