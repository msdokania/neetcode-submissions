class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n, 0, 0, new StringBuilder());
        return ans;
    }
    public void helper(int n, int open, int close, StringBuilder sb) {
        if(open==close && sb.length()==2*n) {
            ans.add(sb.toString());
            return;
        }
        if(open<n) {
            sb.append('(');
            helper(n, open+1, close, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open && close<n) {
            sb.append(')');
            helper(n, open, close+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}



