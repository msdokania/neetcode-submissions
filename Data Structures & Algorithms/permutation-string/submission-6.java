class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        int[] s1f = new int[26];
        int[] s2f = new int[26];
        for(int i=0; i<s1.length(); i++) {
            s1f[s1.charAt(i) - 'a']++;
            s2f[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for(int i=0; i<26; i++) {
            if(s1f[i]==s2f[i]) matches++;
        }
        if(matches==26) return true;
        for(int i=s1.length(); i<s2.length(); i++) {
            int x = s2.charAt(i)-'a';
            if(s2f[x] == s1f[x]) matches--;
            else if(s2f[x] + 1 == s1f[x]) matches++;
            s2f[x]++;
            x = s2.charAt(i-s1.length())-'a';
            if(s2f[x] == s1f[x]) matches--;
            else if(s2f[x] - 1 == s1f[x]) matches++;
            s2f[x]--;
            if(matches==26) return true;
        }
        return false;
    }
}
