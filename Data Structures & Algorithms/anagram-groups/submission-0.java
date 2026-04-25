class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        List<List<String>> ans = new ArrayList();
        for(String str : strs) {
            String code = getHash(str);
            List<String> tmp = hm.getOrDefault(code, new ArrayList<>());
            tmp.add(str);
            hm.put(code, tmp);
        }
        for(List<String> tmp : hm.values())
            ans.add(tmp);
        return ans;
    }

    public String getHash(String s) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c-'a']++;
        }
        for(int i=0; i<26; i++) {
            sb.append(freq[i]);
            sb.append('#');
        }
        return sb.toString();
    }
}
