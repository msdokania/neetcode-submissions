class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        mp = ["","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"]
        ans = []
        if len(digits)==0:
            return ans
        def helper(i: int, curr: str):
            if i==len(digits):
                ans.append(curr)
                return
            for c in mp[int(digits[i])]:
                helper(i+1, curr+c)
        helper(0,"")
        return ans