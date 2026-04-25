class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String, List<String>> hm = new HashMap<>();
        for(int i=0; i<n; i++) {
            String s = strs[i];
            int[] freq = new int[26];
            for(char c : s.toCharArray()) {
                freq[c-'a']++;
            }
            String hash = Arrays.toString(freq);
            hm.putIfAbsent(hash, new ArrayList<>());
            hm.get(hash).add(s);
            // List<String> tmp = hm.getOrDefault(hash, new ArrayList<>());
            // tmp.add(s);
            // hm.put(hash, tmp);
        }
        return new ArrayList<>(hm.values());
    }

    // public String getHash(String str) {
    //     StringBuilder sb = new StringBuilder();
    //     int[] freq = new int[26];
    //     for(char c : str.toCharArray()) {
    //         freq[c-'a']++;
    //     }
    //     for(int i=0; i<26; i++) {
    //         sb.append(freq[i]);
    //         sb.append('#');
    //     }
    //     return sb.toString();
    // }
}
