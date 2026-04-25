class Solution {
    public int firstMissingPositive(int[] nums) {
        int bit = 0;
        int n = nums.length;
        for(int num : nums) {
            if(num>n+1 || num<=0) continue;
            int x = 1<<(num-1);
            bit = bit | x;
        }
        for(int i=0; i<=n; i++) {
            int x = 1<<i;
            if((bit & x) == 0)
                return i+1;
        }
        return 0;
    }
}