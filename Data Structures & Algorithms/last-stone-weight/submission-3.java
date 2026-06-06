class Solution {
    public int lastStoneWeight(int[] stones) {
        int m = 0;
        for(int x : stones) {
            m = Math.max(m, x);
        }
        int[] b = new int[m+1];
        for(int x : stones) {
            b[x]++;
        }
        int first = m;
        while(first>0) {
            if(b[first]%2 == 0) {
                first--;
                continue;
            }
            b[first] = b[first]%2;
            int sec = first-1;
            while(sec>0 && b[sec]==0) {
                sec--;
            }
            if(sec==0) return first;
            b[first]--;
            b[sec]--;
            b[first-sec]++;
            first = Math.max(sec, first-sec);
        }
        return first;
    }
}
