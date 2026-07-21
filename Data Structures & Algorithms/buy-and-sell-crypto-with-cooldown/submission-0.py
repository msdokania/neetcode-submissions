class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        p_buy, p_sell, p_cool = float("-inf"),0,0
        for p in prices:
            b = max(p_buy, p_cool-p)
            s = p_buy + p
            p_cool = max(p_cool, p_sell)
            p_buy = b
            p_sell = s
        return max(p_sell, p_cool)