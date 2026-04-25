class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        helper(new LinkedList<>(), 0, nums);
        return ans;
    }
    public void helper(LinkedList<Integer> cur, int i, int[] nums) {
        if(i==nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        helper(cur, i+1, nums);
        cur.removeLast();
        helper(cur, i+1, nums);
    }
}
