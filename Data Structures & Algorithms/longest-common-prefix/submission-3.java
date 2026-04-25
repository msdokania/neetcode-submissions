class TrieNode {
    Map<Character, TrieNode> hm = new HashMap<>();
}
class Trie {
    TrieNode root = new TrieNode();

    void insert(String s) {
        TrieNode node = root;
        for(char c : s.toCharArray()) {
            node.hm.putIfAbsent(c, new TrieNode());
            node = node.hm.get(c);
        }
    }
    int lcp(String word, int len) {
        int i=0;
        TrieNode node = root;
        while(i < Math.min(word.length(), len)) {
            char c = word.charAt(i);
            if(!node.hm.containsKey(c)) {
                return i;
            }
            i++;
            node = node.hm.get(c);
        }
        return i;
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int lenMin = strs[0].length();
        int miniIdx = 0;
        for(int i=0; i<n; i++) {
            if(strs[i].length() < lenMin) {
                lenMin = strs[i].length();
                miniIdx = i;
            }
        }
        Trie trie = new Trie();
        trie.insert(strs[miniIdx]);
        for(int i=0; i<n; i++) {
            lenMin = trie.lcp(strs[i], lenMin);
        }
        return strs[0].substring(0,lenMin);
    }
}



