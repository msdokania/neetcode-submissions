class Solution {
    Set<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new HashSet<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>());
        return new ArrayList<>(ans);
    }
    public void helper(int[] candidates, int target, int i, List<Integer> curr) {
        if(target==0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target<0 || i==candidates.length) return;
        curr.add(candidates[i]);
        helper(candidates, target-candidates[i], i+1, curr);
        curr.removeLast();
        helper(candidates, target, i+1, curr);
    }
}
