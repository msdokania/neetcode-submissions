class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        def helper(op: int, cl: int, s: str):
            if op==n and cl==n:
                ans.append(s)
                return
            if op<n:
                helper(op+1,cl,s+'(')
            if cl<op:
                helper(op,cl+1,s+')')
        helper(0,0,"")
        return ans