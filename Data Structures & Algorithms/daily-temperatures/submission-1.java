class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++) {
            while(!st.isEmpty() && st.peek()[0]<temperatures[i]) {
                int x = st.peek()[1];
                ans[x] = i-x;
                st.pop();
            }
            st.push(new int[]{temperatures[i], i});
        }
        return ans;
    }
}
