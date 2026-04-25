class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        n = len(strs)
        prefix = strs[0]
        for i in range(1,n):
            x = min(len(prefix), len(strs[i]))
            j = 0
            while j<x:
                if prefix[j] != strs[i][j]:
                    break
                j += 1
            prefix = prefix[:j]
        return prefix
        