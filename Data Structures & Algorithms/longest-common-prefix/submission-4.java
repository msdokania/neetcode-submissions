class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }
    class Trie {
        TrieNode root = new TrieNode();
        public void add(String word) {
            TrieNode curr = root;
            for(char c : word.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
        }

        public String prefix(String x) {
            TrieNode curr = root;
            StringBuilder sb = new StringBuilder();
            for(char c : x.toCharArray()) {
                if(curr.children.containsKey(c)) {
                    sb.append(c);
                    curr = curr.children.get(c);
                }
                else break;
            }
            return sb.toString();
        }
    }
    public String longestCommonPrefix(String[] strs) {
        int min = 0;
        for(int i=1; i<strs.length; i++) {
            if(strs[i].length() < strs[min].length()) 
                min = i;
        }
        Trie t = new Trie();
        t.add(strs[min]);
        String ans = strs[min];
        for(int i=0; i<strs.length; i++) {
            if(i==min) continue;
            String ret = t.prefix(strs[i]);
            if(ans.length() > ret.length())
                ans = ret;
        }
        return ans;
    }
}