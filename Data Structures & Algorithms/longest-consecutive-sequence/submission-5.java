class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int x : nums) hs.add(x);
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            if(hs.contains(nums[i]-1)) continue;
            int tmp = nums[i];
            while(hs.contains(tmp+1)) {
                tmp++;
            }
            ans = Math.max(ans, tmp-nums[i]+1);
        }
        return ans;
    }
}
