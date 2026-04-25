class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        HashSet<Integer> hs = new HashSet();
        for(int num : nums)
            hs.add(num);
        int ans = 1;
        for(int i=0; i<nums.length; i++) {
            if(!hs.contains(nums[i]-1)) {
                int len = 1;
                int x = nums[i];
                while(hs.contains(x+1)) {
                    len++;
                    x++;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
