class Solution {
    public int findDuplicate(int[] nums) {
        int hash = 0;
        for(int num : nums) {
            int tmp = (1<<num);
            if((tmp & hash) != 0)
                return num;
            hash |= tmp;
        }
        return 0;
    }
}

// (1<<num) & hash !=0 return num
// (1<<num) | hash