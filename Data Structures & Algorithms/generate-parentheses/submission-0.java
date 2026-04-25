class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generate("", 0, 0, n);
        return ans;
    }
    public void generate(String curr, int open, int close, int n) {
        if(curr.length() == 2*n && open==close) {
            ans.add(curr);
            return;
        }
        if(open<n)
            generate(curr+"(", open+1, close, n);
        if(close<n && open>close)
            generate(curr+")", open, close+1, n);
    }
}
