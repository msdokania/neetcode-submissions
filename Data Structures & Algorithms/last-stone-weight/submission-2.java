class Solution {
    public int lastStoneWeight(int[] stones) {
        int maxStone = 0;
        for (int stone : stones) {
            maxStone = Math.max(maxStone, stone);
        }
        int[] bucket = new int[maxStone+1];
        for(int x : stones)
            bucket[x]++;
        int first=maxStone;
        while(first>0) {
            if(bucket[first] % 2 == 0) {
                first--;
                continue;
            }
            int sec = first-1;
            while(sec>0 && bucket[sec]==0)
                sec--;
            if(sec==0) return first;
            bucket[first-sec]++;
            bucket[sec]--;
            first--;
        }
        return 0;

        // for(int i=100; i>0; i--) {
        //     if(bucket[i]==0) continue;
        //     if(first!=0) {
        //         int x = first - i;
        //         bucket[x]++;
        //         first = 0;
        //     }
        //     first = i;
        // }
        // if(first==0) return 0;
        // return first;
    }
}

