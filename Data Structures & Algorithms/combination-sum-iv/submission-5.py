class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        n = len(nums)
        nums.sort()
        dp = [-1]*(target+1)

        def traverse(curr):
            if curr>target:
                return 0
            if dp[curr]!=-1:
                return dp[curr]
            if curr==target:
                return 1
            ans = 0
            for j in range(n):
                ans += traverse(curr+nums[j])
            dp[curr] = ans
            return ans

        return traverse(0)