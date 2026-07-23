class TrieNode:
    def __init__(self):
        self.children = {}
        self.end = False
class Trie:
    def __init__(self):
        self.root = TrieNode()
    def add(self,word):
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.end = True

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        t = Trie()
        for w in words:
            t.add(w)
        n,m = len(board), len(board[0])
        ans = set()

        def dfs(r,c,node,curr):
            if r not in range(n) or c not in range(m) or board[r][c] not in node.children or board[r][c]=="#":
                return
            ch = board[r][c]
            curr += ch
            board[r][c] = "#"
            node = node.children[ch]
            if node.end:
                ans.add(curr)
            dfs(r+1,c,node,curr)
            dfs(r-1,c,node,curr)
            dfs(r,c+1,node,curr)
            dfs(r,c-1,node,curr)
            board[r][c] = ch

        for i in range(n):
            for j in range(m):
                dfs(i,j,t.root,"")
        return list(ans)
        