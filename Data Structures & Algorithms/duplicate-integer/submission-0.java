class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(Arrays.stream(nums).distinct().count() < nums.length)
            return true;
        return false;
    }
}