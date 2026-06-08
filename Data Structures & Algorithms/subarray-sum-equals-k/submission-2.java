class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        int currsum = 0;
        int ans = 0;
        for(int x : nums) {
            currsum += x;
            int diff = currsum-k;
            if(hm.containsKey(diff)) {
                ans += hm.get(diff);
            }
            hm.put(currsum, hm.getOrDefault(currsum,0)+1);
        }
        return ans;
    }
}