class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int x : matchsticks)
            sum += x;
        if(sum % 4 != 0) return false;
        int[] sides = new int[4];
        return helper(matchsticks, 0, sum/4, sides);
    }
    public boolean helper(int[] matchsticks, int i, int sideLen, int[] sides) {
        if(i==matchsticks.length) {
            return true;
        }
        for(int j=0; j<4; j++) {
            if(sides[j]+matchsticks[i] > sideLen) {
                continue;
            }
            sides[j] += matchsticks[i];
            boolean x = helper(matchsticks, i+1, sideLen, sides);
            sides[j] -= matchsticks[i];
            if(x) return true;
        }
        return false;
    }
}
