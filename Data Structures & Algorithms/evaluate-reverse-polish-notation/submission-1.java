class Solution {
    public int evalRPN(String[] tokens) {
        int ans = 0;
        Stack<String> st = new Stack<>();
        for(String s : tokens) {
            if(!"+-*/".contains(s))
                st.push(s);
            else if(s.equals("+")) {
                int tmp = Integer.parseInt(st.pop()) + Integer.parseInt(st.pop());
                st.push(String.valueOf(tmp));
            }
            else if(s.equals("-")) {
                int tmp = -Integer.parseInt(st.pop()) + Integer.parseInt(st.pop());
                st.push(String.valueOf(tmp));
            }
            else if(s.equals("*")) {
                int tmp = Integer.parseInt(st.pop()) * Integer.parseInt(st.pop());
                st.push(String.valueOf(tmp));
            }
            else if(s.equals("/")) {
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.pop());
                int tmp = b / a;
                st.push(String.valueOf(tmp));
            }
        }
        return Integer.parseInt(st.pop());
    }
}
