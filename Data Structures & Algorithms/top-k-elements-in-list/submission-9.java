class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-b[1]));
        for(int x : nums) {
            hm.put(x, hm.getOrDefault(x,0)+1);
        }
        for(int x : hm.keySet()) {
            pq.add(new int[]{x, hm.get(x)});
            if(pq.size() > k)
                pq.poll();
        }
        int[] ans = new int[k];
        int i = 0;
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            ans[i++] = tmp[0];
        }
        return ans;
    }
}
