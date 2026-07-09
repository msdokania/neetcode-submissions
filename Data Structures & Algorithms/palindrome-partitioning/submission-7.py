class Solution:
    def partition(self, s: str) -> List[List[str]]:
        ans = []

        def isPalindrome(st: str) -> bool:
            l,r = 0, len(st)-1
            while l<r:
                if st[l]!=st[r]:
                    return False
                l += 1
                r -= 1
            return True

        def helper(i: int, curr: List[str]):
            if i==len(s):
                ans.append(curr.copy())
                return
            for j in range(i, len(s)):
                x = s[i:j+1]
                if isPalindrome(x):
                    curr.append(x)
                    helper(j+1, curr)
                    curr.pop()
        helper(0,[])
        return ans
    