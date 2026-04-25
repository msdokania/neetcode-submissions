class Solution {
    private List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(new ArrayList<>(), 0, target, candidates);
        return ans;
    }
    public void helper(ArrayList<Integer> cur, int i, int target, int[] candidates) {
        if(target==0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if(target<0 || i==candidates.length) {
            return;
        }
        cur.add(candidates[i]);
        helper(cur, i+1, target-candidates[i], candidates);
        cur.remove(cur.size()-1);
        while(i+1<candidates.length && candidates[i]==candidates[i+1]) {
            i++;
        }
        helper(cur, i+1, target, candidates);
    }
}
