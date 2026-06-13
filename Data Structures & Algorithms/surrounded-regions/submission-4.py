class Solution:
    def solve(self, board: List[List[str]]) -> None:
        n,m = len(board), len(board[0])
        q = deque()
        for i in range(n):
            if board[i][0]=="O":
                q.append([i,0])
            if board[i][m-1]=="O":
                q.append([i,m-1])
        for j in range(m):
            if board[0][j]=="O":
                q.append([0,j])
            if board[n-1][j]=="O":
                q.append([n-1,j])
        while q:
            r,c = q.popleft()
            board[r][c] = "S"
            for d in [[0,1],[1,0],[-1,0],[0,-1]]:
                nr,nc = r+d[0], c+d[1]
                if nr<0 or nc<0 or nr>=n or nc>=m or board[nr][nc]!="O":
                    continue
                q.append([nr,nc])
        for i in range(n):
            for j in range(m):
                if board[i][j]=="O":
                    board[i][j] = "X"
                elif board[i][j]=="S":
                    board[i][j] = "O"
