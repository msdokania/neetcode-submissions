class Solution {
    class TrieNode {
        Map<Character, TrieNode> children;
        public TrieNode() {
            children = new HashMap<>();
        }
    }
    class Trie {
        TrieNode root = new TrieNode();
        public void add(String word) {
            TrieNode curr = root;
            for(char c : word.toCharArray()) {
                if(!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
        }
        public int lcp(String word, int len) {
            TrieNode curr = root;
            int i=0;
            while(i < Math.min(len, word.length())) {
                char c = word.charAt(i);
                if(curr.children.containsKey(c)) i++;
                else return i;
                curr = curr.children.get(c);
            }
            return Math.min(len, word.length());
        }
    }
    public String longestCommonPrefix(String[] strs) {
        String minstr = "";
        int minlen = Integer.MAX_VALUE;
        for(String st : strs) {
            if(st.length() < minlen) {
                minstr = st;
                minlen = st.length();
            }
        }
        Trie t = new Trie();
        t.add(minstr);
        int ans = minlen;
        for(String str : strs) {
            ans = t.lcp(str, ans);
        }
        return minstr.substring(0,ans);
    }
}



