class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        int[] indegree = new int[numCourses];
        List<List<Integer>> matrix = new ArrayList<>();
        for(int i=0; i<numCourses; i++)
            matrix.add(new ArrayList<>());
        for(int[] x : prerequisites) {
            matrix.get(x[1]).add(x[0]);
            indegree[x[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++)
            if(indegree[i]==0) q.offer(i);
        int[] ans = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            while(len>0) {
                int course = q.poll();
                ans[idx++] = course;
                numCourses--;
                for(int x : matrix.get(course)) {
                    indegree[x]--;
                    if(indegree[x]==0)
                        q.offer(x);
                }
                if(numCourses==0) return ans;
                len--;
            }
        }
        return numCourses==0? ans : new int[0];
    }
}
