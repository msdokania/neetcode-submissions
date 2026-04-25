class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>());
        return ans;
    }
    public void helper(int[] candidates, int i, int target, List<Integer> curr) {
        if(target<0) return;
        else if(target==0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i>=candidates.length)
            return;
        curr.add(candidates[i]);
        helper(candidates, i+1, target-candidates[i], curr);
        curr.removeLast();
        while(i+1 < candidates.length && candidates[i]==candidates[i+1])
            i++;
        helper(candidates, i+1, target, curr);
    }
}
