class Solution:
    def tribonacci(self, n: int) -> int:
        prev3, prev2, prev = 0, 1, 1
        if n<=2:
            return 0 if n==0 else 1
        for i in range(3, n+1):
            curr = prev + prev2 + prev3
            prev3 = prev2
            prev2 = prev
            prev = curr
        return prev