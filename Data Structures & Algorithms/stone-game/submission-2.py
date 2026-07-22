class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        dp = {}
        def helper(i,j):
            if i>=j:
                return 0
            if (i,j) in dp:
                return dp[(i,j)]
            if (j-i+1)==2:
                return max(piles[i],piles[j])
            turn = True if (j-i+1)%2==0 else False
            score = 0
            if turn:
                score += max(piles[i]+helper(i+1,j), piles[j]+helper(i,j-1))
            else:
                score += max(helper(i+1,j), helper(i,j-1))
            dp[(i,j)] = score
            return score

        alice = helper(0,len(piles)-1)
        bob = sum(piles) - alice
        return alice > bob
        