class TrieNode:
    def __init__(self):
        self.children = {}

class Trie:
    def __init__(self):
        self.root = TrieNode()
    def add(self, word: str) -> None:
        curr = self.root
        idx = 0
        n = len(word)
        while idx<n and word[idx] in curr.children:
            curr = curr.children[word[idx]]
            idx += 1
        while idx < n:
            curr.children[word[idx]] = TrieNode()
            curr = curr.children[word[idx]]
            idx += 1

    def lcp(self, word: str, ln: int) -> int:
        curr = self.root
        idx = 0
        while idx<min(ln, len(word)) and word[idx] in curr.children:
            curr = curr.children[word[idx]]
            idx += 1
        return min(ln, idx)

        

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        n = len(strs)
        prefix = strs[0]
        trie = Trie()
        trie.add(prefix)
        ans = len(prefix)
        for i in range(1,n):
            ans = trie.lcp(strs[i], ans)
            # x = min(len(prefix), len(strs[i]))
            # j = 0
            # while j<x:
            #     if prefix[j] != strs[i][j]:
            #         break
            #     j += 1
            # prefix = prefix[:j]
        return prefix[:ans]
        