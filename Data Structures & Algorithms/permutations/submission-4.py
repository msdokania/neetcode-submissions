class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        ans = []
        def helper(vis: set(), curr: List[int]):
            if len(curr)==len(nums):
                ans.append(curr.copy())
                return
            for i in range(len(nums)):
                if nums[i] in vis:
                    continue
                curr.append(nums[i])
                vis.add(nums[i])
                helper(vis, curr)
                curr.pop()
                vis.remove(nums[i])

        helper(set(), [])
        return ans