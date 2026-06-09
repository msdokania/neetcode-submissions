class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                dist[i][j] = Integer.MAX_VALUE;
        dist[0][0] = 0;
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            if(tmp[1]==n-1 && tmp[2]==m-1) return tmp[0];
            if(dist[tmp[1]][tmp[2]] < tmp[0]) continue;
            for(int[] d : dir) {
                int nr = tmp[1]+d[0], nc = tmp[2]+d[1];
                if(nr>=n||nc>=m||nr<0||nc<0)
                    continue;
                int x = Math.max(tmp[0], Math.abs(heights[tmp[1]][tmp[2]] - heights[nr][nc]));
                if(x < dist[nr][nc]) {
                    dist[nr][nc] = x;
                    pq.offer(new int[]{x, nr, nc});
                }
            }
        }
        return -1;
    }
}