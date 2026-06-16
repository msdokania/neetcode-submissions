class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        prev, curr = cost[0], min(cost[0]+cost[1], cost[1])
        for i in range(2, len(cost)):
            tmp = cost[i] + min(prev,curr)
            prev = curr
            curr = tmp
        return min(prev,curr)
