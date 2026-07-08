class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        ans = []
        def helper(i: int, curr: List[int]):
            if len(curr)==k:
                ans.append(curr.copy())
                return
            if i>n or len(curr)>k:
                return
            curr.append(i)
            helper(i+1, curr)
            curr.pop()
            helper(i+1, curr)
        helper(1,[])
        return ans