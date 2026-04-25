class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0, r=arr.length-1;
        while(r-l+1 > k) {
            if(Math.abs(x-arr[r]) >= Math.abs(x-arr[l])) {
                r--;
            }
            else
                l++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=l; i<=r; i++)
            ans.add(arr[i]);
        return ans;
    }
}