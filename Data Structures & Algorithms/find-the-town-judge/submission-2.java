class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n];
        int[] trustedby = new int[n];
        for(int[] x : trust) {
            trusts[x[0]-1]++;
            trustedby[x[1]-1]++;
        }
        for(int i=0; i<n; i++) {
            if(trusts[i]==0 && trustedby[i]==n-1)
                return i+1;
        }
        return -1;
    }
}

// 1->3 0
// 3->1 n-1