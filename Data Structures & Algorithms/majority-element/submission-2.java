class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<32; i++) {
            int maxone = 0;
            int x = 1<<i;
            for(int num : nums) {
                if((x & num) != 0) 
                    maxone++;
            }
            if(maxone > n/2)
                ans |= x;
        }
        return ans;
    }
}