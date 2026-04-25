class Solution {
    public int majorityElement(int[] nums) {
        int[] bit = new int[32];
        int n = nums.length;
        int ans = 0;
        for(int num : nums) {
            for(int i=0; i<32; i++) {
                bit[i] += ((num >> i) & 1);
            }
        }
        for(int i=0; i<32; i++) {
            if(bit[i] > n/2)
                ans |= (1<<i);
        }
        return ans;
    }
}