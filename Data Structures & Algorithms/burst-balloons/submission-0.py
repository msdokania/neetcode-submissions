class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        nums = [1] + nums + [1]
        n = len(nums)
        dp = [[0]*n for _ in range(n)]
        for gap in range(2,n+1):
            for l in range(n-gap):
                r = l+gap
                best = -1
                for k in range(l+1,r):
                    x = dp[l][k] + nums[l]*nums[k]*nums[r] + dp[k][r]
                    best = max(best,x)
                dp[l][r] = best
        return dp[0][n-1]