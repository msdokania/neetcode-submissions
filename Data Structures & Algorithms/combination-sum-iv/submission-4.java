class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i=1; i<=target; i++) {
            hm.put(i,0);
            for(int num : nums) {
                hm.put(i, hm.get(i)+hm.getOrDefault(i-num, 0));
            }
        }
        return hm.getOrDefault(target,0);
    }
}