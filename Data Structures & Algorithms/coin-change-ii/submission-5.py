class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        coins.sort()
        dp = [[-1]*(amount+1) for _ in range(n)]
        def helper(i,curr):
            if i==n or curr>amount:
                return 0
            if curr==amount:
                return 1
            if dp[i][curr]!=-1:
                return dp[i][curr]
            ret = helper(i,curr+coins[i])
            ret += helper(i+1,curr)
            dp[i][curr] = ret
            return ret
        return helper(0,0)
