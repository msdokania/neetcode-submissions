class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> hm = new HashMap<>();
        for(int[] time : times) {
            List<int[]> tmp = hm.getOrDefault(time[0], new ArrayList<>());
            tmp.add(new int[]{time[1],time[2]});
            hm.put(time[0], tmp);
        }
        Queue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        pq.offer(new int[]{0,k});
        Set<Integer> vis = new HashSet<>();
        vis.add(k);
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            vis.add(tmp[1]);
            if(vis.size()==n) return tmp[0];
            if(hm.containsKey(tmp[1])) {
                for(int[] x : hm.get(tmp[1])) {
                    if(vis.contains(x[0])) continue;
                    pq.offer(new int[]{x[1]+tmp[0], x[0]});
                }
            }
        }
        return -1;
    }
}
