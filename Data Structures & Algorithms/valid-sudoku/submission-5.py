class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [0] * 9
        cols = [0] * 9
        cell = [0] * 9
        # rows = [set() for _ in range(9)]
        # cols = [set() for _ in range(9)]
        # cell = [set() for _ in range(9)]
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    continue
                # val = ord(board[i][j]) - ord('0')
                val = int(board[i][j]) - 1
                if (rows[i] >> val) & 1 != 0:
                    return False
                if (cols[j] >> val) & 1 != 0:
                    return False
                x = (i//3)*3 + j//3
                if (cell[x] >> val) & 1 != 0:
                    return False
                # if board[i][j] in rows[i]:
                #     return False
                # if board[i][j] in cols[j]:
                #     return False
                # x = (i//3)*3 + j//3
                # if board[i][j] in cell[x]:
                #     return False
                rows[i] |= (1 << val)
                cols[j] |= (1 << val)
                cell[x] |= (1 << val)
                # rows[i].add(board[i][j])
                # cols[j].add(board[i][j])
                # cell[x].add(board[i][j])
        return True