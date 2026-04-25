class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i=0; i<n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }
        for(int i=0; i<n; i++) {
            if(hm.containsKey(prefix[i+1]-k))
                ans += hm.get(prefix[i+1]-k);
            hm.put(prefix[i+1], hm.getOrDefault(prefix[i+1],0)+1);
        }
        return ans;
    }
}