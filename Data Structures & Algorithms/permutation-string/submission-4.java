class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i=0; i<s1.length(); i++) {
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }
        int matches = 0;
        for(int i=0; i<26; i++)
            if(freq1[i]==freq2[i]) matches++;
        int l=0;
        for(int i=s1.length(); i<s2.length(); i++) {
            if(matches==26)
                return true;
            int idx = s2.charAt(i)-'a';
            freq2[idx]++;
            if(freq2[idx] == freq1[idx])
                matches++;
            else if(freq2[idx] == 1+freq1[idx])
                matches--;
            idx = s2.charAt(l)-'a';
            freq2[idx]--;
            if(freq2[idx] == freq1[idx])
                matches++;
            else if(freq2[idx]+1 == freq1[idx])
                matches--;
            l++;
        }
        return matches==26;
    }
}
