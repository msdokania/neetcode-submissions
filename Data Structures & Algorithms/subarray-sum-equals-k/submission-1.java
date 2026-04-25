class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // int[] prefix = new int[n+1];
        int currsum = 0;
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        // for(int i=0; i<n; i++) {
        //     prefix[i+1] = prefix[i] + nums[i];
        // }
        for(int i=0; i<n; i++) {
            currsum += nums[i];
            if(hm.containsKey(currsum-k))
                ans += hm.get(currsum-k);
            hm.put(currsum, hm.getOrDefault(currsum,0)+1);
        }
        return ans;
    }
}