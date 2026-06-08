class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<asteroids.length; i++) {
            int curr = asteroids[i];
            while(!st.isEmpty() && curr < 0 && st.peek()>0) {
                int d = curr+st.peek();
                if(d<0)
                    st.pop();
                else if(d>0) {
                    curr = 0;
                } else {
                    curr = 0;
                    st.pop();
                }
            }
            if(curr!=0) st.push(curr);
        }
        int[] ans = new int[st.size()];
        int idx = st.size()-1;
        while(!st.isEmpty()) {
            ans[idx--] = st.peek();
            st.pop();
        }
        return ans;
    }
}