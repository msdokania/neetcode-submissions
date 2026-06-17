class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n==1:
            return nums[0]
        def helper(l: int, r: int) -> int:
            prev = 0
            curr = 0
            for i in range(l, r+1):
                tmp = max(nums[i] + prev, curr)
                prev = curr
                curr = tmp
            return curr

        return max(helper(0,n-2), helper(1,n-1))