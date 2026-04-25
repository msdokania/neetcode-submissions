class Solution {
    class TrieNode {
        Map<Character, TrieNode> hm = new HashMap<>();
    }
    class Trie {
        TrieNode root = new TrieNode();
        public void add(String s) {
            TrieNode curr = root;
            for(char c : s.toCharArray()) {
                curr.hm.putIfAbsent(c, new TrieNode());
                curr = curr.hm.get(c);
            }
        }
        public int lcp(String word, int len) {
            TrieNode curr = root;
            int i=0;
            while(i<Math.min(len, word.length())) {
                if(curr.hm.containsKey(word.charAt(i))) {
                    curr = curr.hm.get(word.charAt(i));
                    i++;
                }
                else return i;
            }
            return Math.min(len, word.length());
        }
    }
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int shortestlen = strs[0].length();
        String min = strs[0];
        for(String s : strs) {
            if(s.length()<shortestlen) {
                shortestlen = s.length();
                min = s;
            }
        }
        Trie t = new Trie();
        t.add(min);
        for(String s : strs) {
            shortestlen = t.lcp(s, shortestlen);
        }
        return min.substring(0,shortestlen);
    }
}





