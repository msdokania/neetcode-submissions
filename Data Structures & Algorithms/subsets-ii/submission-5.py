class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        ans = []
        nums.sort()
        def helper(i: int, curr: List[int]):
            if i==len(nums):
                ans.append(curr.copy())
                return
            curr.append(nums[i])
            helper(i+1, curr)
            curr.pop()
            while i<len(nums)-1 and nums[i+1]==nums[i]:
                i += 1
            helper(i+1, curr)
        helper(0, [])
        return ans