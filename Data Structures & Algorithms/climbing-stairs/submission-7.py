class Solution:
    def climbStairs(self, n: int) -> int:
        prev = 1
        if n==1:
            return prev
        curr = 2
        for i in range(3, n+1):
            tmp = prev+curr
            prev = curr
            curr = tmp
        return curr