class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        side = sum(matchsticks)
        if side%4 != 0:
            return False
        side = side//4

        matchsticks.sort(reverse=True)
        if matchsticks[0]>side:
            return False

        def helper(i: int, arr: List[int]):
            if i==len(matchsticks):
                return True
            ret = False
            seen = set()
            for j in range(4):
                if arr[j] in seen:
                    continue
                if arr[j]+matchsticks[i] <= side:
                    arr[j] += matchsticks[i]
                    seen.add(arr[j])
                    ret = ret or helper(i+1, arr)
                    arr[j] -= matchsticks[i]
            return ret

        return helper(0, [0,0,0,0])