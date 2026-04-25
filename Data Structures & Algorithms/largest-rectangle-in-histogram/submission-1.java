class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        int ans = 0;
        for(int i=0; i<heights.length; i++) {
            ans = Math.max(ans, heights[i]);
            int idx = i;
            while(!st.isEmpty() && heights[i]<=st.peek()[0]) {
                int[] tmp = st.pop();
                ans = Math.max(ans, (i-tmp[1]+1)*heights[i]);
                idx = tmp[1];
            }
            if(st.isEmpty()) {
                st.push(new int[]{heights[i],idx});
                continue;
            }
            ans = Math.max(ans, (i-st.peek()[1]+1)*st.peek()[0]);
            st.push(new int[]{heights[i], idx});
        }
        int max = -1;
        while(!st.isEmpty()) {
            int[] tmp = st.pop();
            if(max==-1) max = tmp[1];
            ans = Math.max(ans, (max-tmp[1]+1)*tmp[0]);
        }
        return ans;
    }
}
