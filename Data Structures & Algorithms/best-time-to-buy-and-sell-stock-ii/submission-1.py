class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = prices[0]
        ans = 0
        for i in range(1, len(prices)):
            if prices[i] > buy:
                ans += prices[i] - buy
            buy = prices[i]
        return ans