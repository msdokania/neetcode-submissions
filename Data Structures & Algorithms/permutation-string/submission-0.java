class Solution {
    public boolean checkInclusion(String s1, String s2) {
        String code_s1 = getHash(s1,0,s1.length());
        for(int i=0; i<=s2.length()-s1.length(); i++) {
            String code_s2 = getHash(s2, i, s1.length());
            if(code_s1.equals(code_s2))
                return true;
        }
        return false;
    }

    public String getHash(String s, int start, int len) {
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        for(int i=start; i<start+len; i++) {
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++) {
            sb.append(freq[i]);
            sb.append('#');
        }
        return sb.toString();
    }
}
