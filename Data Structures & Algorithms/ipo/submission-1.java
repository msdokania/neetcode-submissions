class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Queue<int[]> maxProfit = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        Queue<int[]> minCapital = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        for(int i=0; i<n; i++) {
            minCapital.offer(new int[]{profits[i],capital[i]});
        }
        while(k>0) {
            if(!minCapital.isEmpty() && minCapital.peek()[1] > w)
                return w;
            while(!minCapital.isEmpty() && minCapital.peek()[1] <= w)
                maxProfit.offer(minCapital.poll());
            int[] tmp = maxProfit.poll();
            w += tmp[0];
            k--;
        }
        return w;
    }
}