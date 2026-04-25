class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        if (k == 0) return;
        int count = 0;
        for(int i=0; count<n; i++) {
            int start = i;
            int prev = nums[i];
            int curr = (start+k)%n;
            while(start!=curr) {
                int tmp = nums[curr];
                nums[curr] = prev;
                prev = tmp;
                curr = (curr+k)%n;
                count++;
            }
            nums[curr] = prev;
            count++;
        }
    }
}

// 0   1   2   3   4   5   6   7
// 5   6   3   4   1   2   7   8
//     s               
//                     c

// prev = 6


