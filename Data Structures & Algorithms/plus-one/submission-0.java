class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> arr = new ArrayList<>();
        int n = digits.length;
        int carry = 1;
        int i = n-1;
        for(i=n-1; i>=0; i--) {
            int x = digits[i] + carry;
            arr.add(x%10);
            carry = x/10;
            if(carry==0)
                break;
        }
        i--;
        while(i>=0)
            arr.add(digits[i--]);
        if(carry>0)
            arr.add(carry);
        int[] ans = new int[arr.size()];
        for(int j=0; j<arr.size(); j++) {
            ans[j] = arr.get(arr.size()-j-1);
        }
        return ans;
    }
}
