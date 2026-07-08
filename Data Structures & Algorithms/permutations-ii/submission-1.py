class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        ans = set()
        def helper(vis: List[bool], curr: List[int]):
            if len(curr)==len(nums):
                ans.add(tuple(curr.copy()))
                return
            for i in range(len(nums)):
                if vis[i]:
                    continue
                curr.append(nums[i])
                vis[i] = True
                helper(vis,curr)
                curr.pop()
                vis[i] = False
        helper([False] * len(nums),[])
        return [list(x) for x in ans]