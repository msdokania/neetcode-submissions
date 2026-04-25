class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] minEff = new int[n][m];
        Queue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for(int i=0; i<n; i++)
            Arrays.fill(minEff[i], Integer.MAX_VALUE);
        minEff[0][0] = 0;
        pq.offer(new int[]{0,0,0});
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int eff = tmp[0], r=tmp[1], c=tmp[2];
            if(r==n-1 && c==m-1)
                return eff;
            for(int[] d : dir) {
                int nr = r+d[0];
                int nc = c+d[1];
                if(nr>=n || nr<0 || nc>=m || nc<0)
                    continue;
                int x = Math.max(eff, Math.abs(heights[nr][nc]-heights[r][c]));
                if(minEff[nr][nc] > x) {
                    minEff[nr][nc] = x;
                    pq.offer(new int[]{x, nr, nc});
                }
            }
        } 
        return -1;
    }
}