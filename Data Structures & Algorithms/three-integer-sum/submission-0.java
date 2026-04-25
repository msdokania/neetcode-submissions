class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n-2; i++) {
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int l=i+1, r=n-1;
            int target = -nums[i];
            while(l<r) {
                if(l!=i+1 && nums[l]==nums[l-1]) {
                    l++;
                    continue;
                }
                if(nums[l]+nums[r] == target) {
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                }
                else if(nums[l]+nums[r] < target)
                    l++;
                else
                    r--;
            }
        }
        return ans;
    }
}
