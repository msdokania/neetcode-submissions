class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n==1:
            return nums[0]

        def helper(l: int, r: int) -> int:
            prev = 0
            curr = nums[l]
            for i in range(l+1, r+1):
                r = nums[i]+prev
                nr = max(prev,curr)
                prev = curr
                curr = max(r,nr)
            return curr

        return max(helper(0,n-2), helper(1,n-1))