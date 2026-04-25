class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1];
        for(int i=0; i<=nums.length; i++)
            freq[i] = new ArrayList<>();
        for(int x : nums)
            count.put(x, count.getOrDefault(x,0)+1);
        for(int x : count.keySet()) {
            freq[count.get(x)].add(x);
        }
        int[] ans = new int[k];
        int idx = 0;
        for(int i=nums.length; i>0; i--) {
            if(idx==k) break;
            if(freq[i].size()==0) continue;
            for(int tmp : freq[i]) {
                ans[idx++] = tmp;
                if(idx==k) break;
            }
        }
        return ans;
    }
}
