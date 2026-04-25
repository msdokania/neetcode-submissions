class Solution {
    HashSet<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new HashSet<>();
        Arrays.sort(candidates);
        helper(new LinkedList<>(), 0, target, candidates);
        return new ArrayList<>(ans);
    }
    public void helper(LinkedList<Integer> curr, int i, int target, int[] candidates) {
        if(target==0) {
            // Collections.sort(curr);
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i==candidates.length || target<0)
            return;
        // if(i==0 || candidates[i]!=candidates[i-1]) {
            curr.add(candidates[i]);
            helper(curr, i+1, target-candidates[i], candidates);
            curr.removeLast();
        // }
        helper(curr, i+1, target, candidates);
    }
}


