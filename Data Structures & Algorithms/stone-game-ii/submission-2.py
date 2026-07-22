class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)
        dp = {}

        def helper(turn, i, M):
            if i==n:
                return 0
            if (turn,i,M) in dp:
                return dp[(turn,i,M)]
            res = 0 if turn else float("inf")
            curr = 0
            for x in range(2*M):
                if i+x >= n:
                    break
                curr += piles[i+x] if turn else 0
                if turn:
                    res = max(res, curr + helper(not turn, i+x+1, max(x+1,M)))
                else:
                    res = min(res, curr + helper(not turn, i+x+1, max(x+1,M)))
            dp[(turn,i,M)] = res
            return res

        return helper(True,0,1)
        

