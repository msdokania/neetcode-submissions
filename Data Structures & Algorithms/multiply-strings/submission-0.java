class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int[] res = new int[num1.length() + num2.length() + 1];
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for(int i=0; i<num1.length(); i++) {
            int carry = 0;
            int j=0;
            for(j=0; j<num2.length(); j++) {
                int num = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                res[i+j] += carry + num;
                carry = res[i+j]/10;
                res[i+j] = res[i+j] % 10;
            }
            if(carry>0) {
                res[i+j] += carry;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = num1.length() + num2.length();
        while(i>=0 && res[i]==0) {
            i--;
        }
        while(i>=0) {
            sb.append(res[i]);
            i--;
        }
        return sb.toString();
    }
}
