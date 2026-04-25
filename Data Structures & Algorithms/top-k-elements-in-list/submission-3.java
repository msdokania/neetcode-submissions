class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<List<Integer>> freqArr = new ArrayList<>();
        Map<Integer, Integer> hm = new HashMap<>();
        int[] ans = new int[k];
        for(int i=0; i<n; i++) {
            freqArr.add(new ArrayList<>());
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        } // freq 1 2 3 - - -
        for(int key : hm.keySet()) {
            freqArr.get(hm.get(key)-1).add(key);
        }
        int idx = 0;
        for(int i=n-1; i>=0; i--) {
            List<Integer> tmp = freqArr.get(i);
            for(int x : tmp) {
                ans[idx++] = x;
                if(idx==k) return ans;
            }
        }
        return ans;
    }
}
