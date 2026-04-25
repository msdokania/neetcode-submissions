class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int ans = 1;
        int last = 0;
        int curr = 1;
        for(int i=1; i<arr.length; i++) {
            if(arr[i]==arr[i-1]) {
                last = 0;
                curr = 1;
            } else if(arr[i] > arr[i-1]) {
                if(last==1 || last==0) {
                    curr = 2;
                } else {
                    curr++;
                    last = 1;
                }
            } else {
                if(last==-1) {
                    curr = 2;
                } else {
                    curr++;
                    last = -1;
                }
            }
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}