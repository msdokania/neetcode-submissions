class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int x : matchsticks)
            sum += x;
        if(sum%4 != 0) return false;
        int side = sum/4;
        return helper(matchsticks, 0, side, new int[4]);
    }
    public boolean helper(int[] matchsticks, int i, int side, int[] curr) {
        if(i==matchsticks.length)
            return true;
        for(int j=0; j<4; j++) {
            if(curr[j]==side || matchsticks[i]+curr[j]>side)
                continue;
            curr[j] += matchsticks[i];
            if(helper(matchsticks, i+1, side, curr))
                return true;
            curr[j] -= matchsticks[i];
        }
        return false;
    }
}

// 16%4 != 0
// side = 4

// arr[4] = - - - -