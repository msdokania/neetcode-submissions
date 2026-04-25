class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> hs = new HashSet<>(Arrays.asList(deadends));
        if(hs.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        hs.add("0000");
        int turns = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            while(len>0) {
                String tmp = q.poll();
                if(tmp.equals(target)) return turns;
                for(String s : helper(tmp)) {
                    if(!hs.contains(s) && !hs.contains(s)) {
                        hs.add(s);
                        q.offer(s);
                    }
                }
                len--;
            }
            turns++;
        }
        return -1;
    }
    public List<String> helper(String s) {
        List<String> ret = new ArrayList<>();
        for(int i=0; i<4; i++) {
            char[] c = s.toCharArray();
            char tmp = c[i];
            c[i] = (char)((((c[i]-'0') - 1 + 10)%10)+'0');
            ret.add(new String(c));
            c[i] = (char)(((tmp-'0')+1)%10 +'0');
            ret.add(new String(c));
        }
        return ret;
    }
}

