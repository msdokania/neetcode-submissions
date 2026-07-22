class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        dp = {}
        def helper(i,j,idx):
            if idx==len(s3):
                return i==len(s1) and j==len(s2)
            if (i,j) in dp:
                return dp[(i,j)]
            ret = False
            if i<len(s1) and s3[idx]==s1[i]:
                ret = ret or helper(i+1,j,idx+1)
            if not ret and j<len(s2) and s3[idx]==s2[j]:
                ret = ret or helper(i,j+1,idx+1)
            dp[(i,j)] = ret
            return ret

        return helper(0,0,0)
            

