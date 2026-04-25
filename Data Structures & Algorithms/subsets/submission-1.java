class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }
    public void backtrack(int[] nums, int i, List<Integer> curr) {
        if(i==nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        backtrack(nums, i+1, curr);
        curr.removeLast();
        backtrack(nums, i+1, curr);
    }
}

// 1                   []
// 12  1               2   []
// 123 12 13 1         23 2 3 []
    // -  -