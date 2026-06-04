class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        List<Integer>[] bucket = new List[n+1];
        for(int i=0; i<n+1; i++)
            bucket[i] = new ArrayList<>();
        for(int x : nums) {
            hm.put(x, hm.getOrDefault(x,0)+1);
        }
        for(int x : hm.keySet()) {
            int freq = hm.get(x);
            bucket[freq].add(x);
        }
        int[] ans = new int[k];
        int idx = 0;
        for(int i=n; i>0; i--) {
            if(bucket[i].size() != 0) {
                for(int tmp : bucket[i]) {
                    ans[idx++] = tmp;
                    if(idx==k) return ans;
                }
            }
        }
        return ans;
    }
}
