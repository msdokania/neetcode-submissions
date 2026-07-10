class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        ans = [0,0]

        def helper(l: int, r: int) -> List[int]:
            while l>=0 and r<len(s) and s[l]==s[r]:
                l -= 1
                r += 1
            return [l+1, r-1]

        for i in range(len(s)):
            a = helper(i,i)
            if a[1]-a[0]+1 > ans[1]-ans[0]+1:
                ans[0] = a[0]
                ans[1] = a[1]
            if i!=n-1 and s[i]==s[i+1]:
                a = helper(i,i+1)
                if a[1]-a[0]+1 > ans[1]-ans[0]+1:
                    ans[0] = a[0]
                    ans[1] = a[1]
        return s[ans[0]:ans[1]+1]