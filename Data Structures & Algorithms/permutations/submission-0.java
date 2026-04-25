class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        helper(new ArrayList<>(), nums, 0);
        return ans;
    }
    public void helper(List<Integer> cur, int[] nums, int mask) {
        if(cur.size()==nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            int x = (1<<i);
            if((mask & x) == 0) {
                cur.add(nums[i]);
                helper(cur, nums, mask | x);
                cur.remove(cur.size()-1);
            }
        }
    }
}
