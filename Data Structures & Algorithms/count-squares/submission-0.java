class CountSquares {
    Map<List<Integer>, Integer> hm;
    List<List<Integer>> pts;

    public CountSquares() {
        hm = new HashMap<>();
        pts = new ArrayList<>();
    }
    
    public void add(int[] point) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(point[0]);
        tmp.add(point[1]);
        hm.put(tmp, hm.getOrDefault(tmp,0)+1);
        pts.add(tmp);
    }
    
    public int count(int[] point) {
        int px=point[0], py = point[1];
        int ans = 0;
        for(List<Integer> l : pts) {
            int x=l.get(0), y=l.get(1);
            if(Math.abs(x-px) != Math.abs(y-py) || (x==px && y==py))
                continue;
            ans += (hm.getOrDefault(Arrays.asList(px,y),0)) * (hm.getOrDefault(Arrays.asList(x,py),0));
        }
        return ans;
    }
}
