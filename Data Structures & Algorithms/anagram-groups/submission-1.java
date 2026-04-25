class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;
        if(n==0) return ans;
        HashMap<String, List<String>> hm = new HashMap<>();
        for(int i=0; i<n; i++) {
            String s = strs[i];
            String hash = getHash(s);
            List<String> tmp = hm.getOrDefault(hash, new ArrayList<>());
            tmp.add(s);
            hm.put(hash, tmp);
        }
        for(String s : hm.keySet()) {
            ans.add(hm.get(s));
        }
        return ans;
    }

    public String getHash(String str) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for(char c : str.toCharArray()) {
            freq[c-'a']++;
        }
        for(int i=0; i<26; i++) {
            sb.append(freq[i]);
            sb.append('#');
        }
        return sb.toString();
    }
}
