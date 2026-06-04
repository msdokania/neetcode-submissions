class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int idx = 0;
        for(int r=0; r<n; r++) {
            int l = r-k+1;
            while(!dq.isEmpty() && nums[dq.peekFirst()]<nums[r]) {
                dq.pollFirst();
            }
            dq.offerFirst(r);
            if(dq.peekLast()<l)
                dq.pollLast();
            if(r>=k-1)
                ans[idx++] = nums[dq.peekLast()];
        }
        return ans;
    }
}
