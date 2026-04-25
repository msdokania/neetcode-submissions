class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        helper(0,0, n, new StringBuilder());
        return ans;
    }
    public void helper(int open, int close, int n, StringBuilder curr) {
        if(curr.length() == 2*n) {
            ans.add(curr.toString());
            return;
        }
        if(open<n) {
            curr.append('(');
            helper(open+1, close, n, curr);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close<open) {
            curr.append(')');
            helper(open, close+1, n, curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}



// can i have open? 
//     yes 
//     No: can i have closing