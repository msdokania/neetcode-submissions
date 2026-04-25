class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int n = temperatures.length;
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && st.peek()[0]<temperatures[i]) {
                int[] tmp = st.pop();
                temperatures[tmp[1]] = i-tmp[1];
            }
            st.push(new int[]{temperatures[i], i});
        }
        while(!st.isEmpty()) {
            int[] tmp = st.pop();
            temperatures[tmp[1]] = 0;
        }
        return temperatures;
    }
}
