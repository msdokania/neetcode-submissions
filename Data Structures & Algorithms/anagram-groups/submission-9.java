class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for(String s : strs) {
            StringBuilder hash = new StringBuilder();
            int[] freq = new int[26];
            for(char c : s.toCharArray()) {
                freq[c-'a']++;
            }
            for(int i=0; i<26; i++) {
                hash.append(freq[i]);
                hash.append('#'); 
            }
            List<String> tmp = hm.getOrDefault(hash.toString(), new ArrayList<>());
            tmp.add(s);
            hm.put(hash.toString(), tmp);
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> l : hm.values())
            ans.add(l);
        return ans;
    }
}
