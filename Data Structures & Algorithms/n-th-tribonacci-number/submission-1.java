class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n<3) return 1;
        int a=0, b=1, c=1;
        for(int i=3; i<=n; i++) {
            int x = a+b+c;
            a=b;
            b=c;
            c=x;
        }
        return c;
    }
}