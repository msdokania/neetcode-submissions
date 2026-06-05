class MinStack {
    Stack<int[]> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int x = st.isEmpty()? val : st.peek()[1];
        st.push(new int[]{val, Math.min(val, x)});
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}
