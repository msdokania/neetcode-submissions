class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
        def dfs(i: int, curr: List[int]):
            if i==len(nums):
                ans.append(curr.copy())
                return
            curr.append(nums[i])
            dfs(i+1, curr)
            curr.pop()
            dfs(i+1, curr)
        dfs(0, [])
        return ans