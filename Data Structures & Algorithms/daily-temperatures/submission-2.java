class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        st.push(new int[]{temperatures[n-1], n-1});
        int idx = n-2;
        for(int i=n-2; i>=0; i--) {
            while(!st.isEmpty() && st.peek()[0] <= temperatures[i]) {
                st.pop();
            }
            int x = st.isEmpty()? 0 : st.peek()[1]-i;
            ans[idx--] = x;
            st.push(new int[]{temperatures[i], i});
        }
        return ans;
    }
}
