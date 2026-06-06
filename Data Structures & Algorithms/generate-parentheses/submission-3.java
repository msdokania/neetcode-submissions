class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        helper(0,0,2*n,new StringBuilder());
        return ans;
    }
    public void helper(int open, int close, int total, StringBuilder sb) {
        if(open==close && open*2==total) {
            String tmp = new StringBuilder(sb).toString();
            ans.add(tmp);
            return;
        }
        if(close<open) {
            sb.append(')');
            helper(open,close+1,total,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(open<total/2) {
            sb.append('(');
            helper(open+1,close, total, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
