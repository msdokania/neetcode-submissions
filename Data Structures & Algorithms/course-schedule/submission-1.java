class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while(!q.isEmpty()) {
            int len = q.size();
            while(len>0) {
                int course = q.poll();
                numCourses--;
                for(int x : matrix.get(course)) {
                    indegree[x]--;
                    if(indegree[x]==0)
                        q.offer(x);
                }
                if(numCourses==0) return true;
                len--;
            }
        }
        return false;
    }
}
