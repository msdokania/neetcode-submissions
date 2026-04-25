class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length, m=heights[0].length;
        Queue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        pq.offer(new int[]{0,0,0});
        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            if(tmp[1]==n-1 && tmp[2]==m-1) return tmp[0];
            int difftillnow = tmp[0];
            if(dist[tmp[1]][tmp[2]] < difftillnow) continue;
            for(int[] d : dir) {
                int nr = tmp[1]+d[0], nc = tmp[2]+d[1];
                if(nr>=n||nc>=m||nr<0||nc<0)
                    continue;
                int newdiff = Math.max(difftillnow, Math.abs(heights[nr][nc] - heights[tmp[1]][tmp[2]]));
                if(newdiff < dist[nr][nc]) {
                    dist[nr][nc] = newdiff;
                    pq.offer(new int[]{newdiff,nr,nc});
                }
            }
        }
        return -1;
    }
}


// , 210, 312
// 0 0 0
// 2 1 3




