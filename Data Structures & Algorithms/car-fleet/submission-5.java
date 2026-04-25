class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            int dist = target-position[i];
            arr[i] = new int[]{dist, speed[i]};
        }
        Arrays.sort(arr, (a,b) -> (a[0]-b[0]));
        double prevTime = (double)arr[0][0]/(double)arr[0][1];
        int ans = 1;
        for(int i=1; i<n; i++) {
            double currTime = (double)arr[i][0]/(double)arr[i][1];
            if(currTime > prevTime) {
                prevTime = currTime;
                ans++;
            }
        }
        return ans;
    }
}
