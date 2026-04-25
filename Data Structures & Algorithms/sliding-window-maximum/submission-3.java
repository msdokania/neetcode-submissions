class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int idx = 0;
        for(int i=0; i<k; i++) {
            while(!dq.isEmpty() && dq.peekLast()[0]<=nums[i]) {
                dq.pollLast();
            }
            dq.offerFirst(new int[]{nums[i],i});
        }
        ans[idx++] = dq.peekLast()[0];
        for(int i=k; i<n; i++) {
            while(!dq.isEmpty() && dq.peekLast()[1]<=i-k)
                dq.pollLast();
            while(!dq.isEmpty() && dq.peekLast()[0]<=nums[i])
                dq.pollLast();
            if(dq.isEmpty())
                dq.offerLast(new int[]{nums[i],i});
            else {
                while(!dq.isEmpty() && dq.peekFirst()[1]<=i-k)
                    dq.pollFirst();
                while(!dq.isEmpty() && dq.peekFirst()[0]<=nums[i])
                    dq.pollFirst();
                dq.offerFirst(new int[]{nums[i],i});
            }
            ans[idx++] = dq.peekLast()[0];
        }
        return ans;
    }
}


// remove irrelevant indexes
// if(curr>=last) remove all maller onnes & put in queueend -> output the end
// else remove irrelevant -> remove all smaller -> put in front ->output