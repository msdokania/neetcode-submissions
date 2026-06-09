class Twitter {
    Map<Integer, ArrayDeque<int[]>> posts;
    Map<Integer, Set<Integer>> follow;
    int time;

    public Twitter() {
        posts = new HashMap<>();
        follow = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        ArrayDeque<int[]> dq = posts.getOrDefault(userId, new ArrayDeque<>());
        time++;
        dq.offerLast(new int[]{tweetId, time});
        if(dq.size()>10)
            dq.pollFirst();
        posts.put(userId, dq);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> hs = follow.getOrDefault(userId, new HashSet<>());
        hs.add(userId);
        Queue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        for(int f : hs) {
            ArrayDeque<int[]> tmp = posts.getOrDefault(f, new ArrayDeque<>());
            for(int[] p : tmp) {
                pq.offer(p);
                if(pq.size()>10) pq.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()) {
            ans.add(pq.peek()[0]);
            pq.poll();

        }
        Collections.reverse(ans);
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> hs = follow.getOrDefault(followerId, new HashSet<>());
        hs.add(followeeId);
        follow.put(followerId, hs);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> hs = follow.get(followerId);
        hs.remove(followeeId);
        follow.put(followerId, hs);
    }
}
