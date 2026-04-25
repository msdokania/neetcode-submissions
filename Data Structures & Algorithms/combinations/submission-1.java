class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        helper(n, 1, k, new ArrayList<>());
        return ans;
    }
    public void helper(int n, int i, int k, List<Integer> curr) {
        if(k==0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i>n) return;
        curr.add(i);
        helper(n, i+1, k-1, curr);
        curr.removeLast();
        helper(n, i+1, k, curr);
    }
}