class Solution {
    public int findDuplicate(int[] nums) {
        int ans = 0;
        for(int i=0; i<32; i++) {
            int mask = 1<<i;
            int x = 0, y = 0;
            for(int num : nums) {
                if((num & mask) != 0) x++;
            }
            for(int j=1; j<nums.length; j++) {
                if((j & mask) != 0) y++;
            }
            if(x>y)
                ans |= mask;
        }
        return ans;
    }
}
