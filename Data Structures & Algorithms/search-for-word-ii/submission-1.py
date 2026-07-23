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

        def helper(r,c,vis,node,curr):
            if r not in range(n) or c not in range(m) or vis[r][c] or board[r][c] not in node.children:
                return
            vis[r][c] = True
            tmp = board[r][c]
            node = node.children[tmp]
            curr += tmp
            if node.end:
                ans.add(curr)
            helper(r+1,c,vis,node,curr)
            helper(r-1,c,vis,node,curr)
            helper(r,c+1,vis,node,curr)
            helper(r,c-1,vis,node,curr)
            vis[r][c] = False
        
        for i in range(n):
            for j in range(m):
                vis = [[False]*m for _ in range(n)]
                helper(i,j,vis,t.root,"")
        return list(ans)



        