class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        n,m = len(board), len(board[0])
        def helper(r: int, c: int, idx: int):
            if idx==len(word):
                return True
            ret = False
            for d in [[0,1],[1,0],[-1,0],[0,-1]]:
                nr, nc = r+d[0], c+d[1]
                if nr<0 or nc<0 or nr>=n or nc>=m or board[nr][nc]=='.':
                    continue
                if board[nr][nc] == word[idx]:
                    board[nr][nc] = '.'
                    ret = ret or helper(nr,nc,idx+1)
                    board[nr][nc] = word[idx]
            return ret

        for i in range(n):
            for j in range(m):
                if board[i][j]==word[0]:
                    board[i][j] = '.'
                    x = helper(i,j,1)
                    board[i][j] = word[0]
                    if x:
                        return True
        return False
                