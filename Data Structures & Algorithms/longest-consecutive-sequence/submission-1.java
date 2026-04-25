class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        int ans = 0;
        for(int num : nums)
            hs.add(num);
        for(int num : hs) {
            int currNum = num;
            int streak = 1;
            if(hs.contains(currNum-1)) continue;
            while(hs.contains(currNum+1)) {
                streak++;
                currNum++;
            }
            ans = Math.max(ans, streak);
        }
        return ans;
    }
}
