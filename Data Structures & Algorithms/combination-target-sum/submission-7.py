class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        ans = []
        def helper(i: int, curr: List[int]):
            if i==len(nums) or sum(curr)>target:
                return
            if sum(curr)==target:
                ans.append(curr.copy())
                return
            curr.append(nums[i])
            helper(i, curr)
            curr.pop()
            helper(i+1, curr)
        helper(0,[])
        return ans