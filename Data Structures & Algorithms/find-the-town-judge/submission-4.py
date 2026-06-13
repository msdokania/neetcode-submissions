class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n==1:
            return 1
        arr = [0] * n
        for a in trust:
            arr[a[1]-1] += 1
            arr[a[0]-1] -= 1
        for i in range(n):
            if arr[i]==n-1:
                return i+1
        return -1


