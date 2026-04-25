class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]!=b[1]?b[1]-a[1] : b[2]-a[2]));
        for(int i=0; i<arr.length; i++) {
            int[] tmp = {arr[i], Math.abs(x-arr[i]), i};
            pq.offer(tmp);
            if(pq.size()>k)
                pq.poll();
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()) {
            ans.add(pq.peek()[0]);
            pq.poll();
        }
        Collections.sort(ans);
        return ans;
    }
}