class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        String s1Hash = getHash(s1);
        for(int i=0; i<=s2.length()-s1.length(); i++) {
            String s2Hash = getHash(s2.substring(i, i+s1.length()));
            if(s1Hash.equals(s2Hash))
                return true;
        }
        return false;
    }
    public String getHash(String s) {
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray())
            freq[c-'a']++;
        for(int i=0; i<26; i++) {
            sb.append(freq[i]);
            sb.append('#');
        }
        return sb.toString();
    }
}


