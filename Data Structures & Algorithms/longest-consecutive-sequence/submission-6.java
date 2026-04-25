class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> hs = new HashSet<>();
        for(int x : nums)
            hs.add(x);
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(!hs.contains(nums[i]-1)) {
                int count = 1;
                int x = nums[i];
                while(hs.contains(x+1)) {
                    count++;
                    x++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
