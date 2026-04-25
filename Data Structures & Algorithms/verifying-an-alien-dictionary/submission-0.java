class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        Map<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<order.length(); i++) 
            hm.put(order.charAt(i), i);
        for(int i=0; i<n-1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];
            for(int j=0; j<s1.length(); j++) {
                if(j==s2.length())
                    return false;
                if(s1.charAt(j) != s2.charAt(j)) {
                    if(hm.get(s1.charAt(j)) > hm.get(s2.charAt(j)))
                        return false;
                    break;
                }
            }
        }
        return true;
    }
}