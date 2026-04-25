class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int l=0, r=0;
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        while(r<k) {
            while(!dq.isEmpty() && dq.peekFirst()[0]<nums[r])
                dq.pollFirst();
            dq.offerFirst(new int[]{nums[r], r});
            r++;
        }
        ans[0] = dq.peekLast()[0];
        int idx = 1;
        while(r<n) {
            while(!dq.isEmpty() && dq.peekFirst()[0]<nums[r])
                dq.pollFirst();
            dq.offerFirst(new int[]{nums[r], r});
            while(!dq.isEmpty() && dq.peekLast()[1]<=r-k)
                dq.pollLast();
            ans[idx++] = dq.isEmpty()? -1 : dq.peekLast()[0];
            r++;
        }
        return ans;
    }
}
