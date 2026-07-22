class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        n = len(nums)
        S = sum(nums)
        dp = [[-1]*(2*S +1) for _ in range(n)]

        def helper(i,curr):
            if i==n:
                return 1 if curr==target else 0
            if dp[i][curr+S]!=-1:
                return dp[i][curr+S]
            ret = helper(i+1,curr+nums[i]) + helper(i+1,curr-nums[i])
            dp[i][curr+S] = ret
            return ret

        return helper(0,0)