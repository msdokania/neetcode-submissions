class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Queue<int[]> pq = new PriorityQueue<>((x,y)->(y[0]-x[0]));
        if(a!=0) pq.offer(new int[]{a, 'a'});
        if(b!=0) pq.offer(new int[]{b, 'b'});
        if(c!=0) pq.offer(new int[]{c, 'c'});
        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()) {
            int[] first = pq.poll();
            int n = res.length();
            char ch = (char) first[1];
            if(res.length()>1 && res.charAt(n-1)==ch && res.charAt(n-2)==ch) {
                if(pq.isEmpty()) return res.toString();
                int[] sec = pq.poll();
                res.append((char)sec[1]);
                sec[0]--;
                if(sec[0]!=0) pq.offer(sec);
                pq.offer(first);
                continue;
            }
            res.append((char)first[1]);
            first[0]--;
            if(first[0]!=0) pq.offer(first);
        }
        return res.toString();
    }
}

// [1,c]
// res = "ccbcc"



