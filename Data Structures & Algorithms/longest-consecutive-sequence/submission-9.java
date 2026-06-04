class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> hs = new HashSet<>();
        for(int num : nums)
            hs.add(num);
        for(int num : nums) {
            int len = 1;
            int x = num;
            if(!hs.contains(x-1)) {
                while(hs.contains(x+1)) {
                    len++;
                    x++;
                }
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
