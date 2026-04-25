class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(new ArrayList<>(), 0, nums);
        return ans;
    }
    public void helper(List<Integer> cur, int i, int[] nums) {
        if(i==nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }  
        cur.add(nums[i]);
        helper(cur, i+1, nums);
        cur.remove(cur.size()-1);
        while(i+1 < nums.length && nums[i+1]==nums[i])
            i++;
        helper(cur, i+1, nums);
    }
}
