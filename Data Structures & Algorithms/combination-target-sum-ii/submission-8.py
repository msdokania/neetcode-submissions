class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        ans = []
        def helper(i: int, currsum: int, curr: List[int]):
            if currsum==target:
                ans.append(curr.copy())
                return
            if i==len(candidates) or currsum>target:
                return
            
            curr.append(candidates[i])
            helper(i+1, currsum+candidates[i], curr)
            curr.pop()
            while i<len(candidates)-1 and candidates[i+1]==candidates[i]:
                i += 1
            helper(i+1, currsum, curr)
        helper(0,0,[])
        return ans