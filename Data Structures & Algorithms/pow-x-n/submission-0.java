class Solution {
    public double myPow(double x, int n) {
        if(n==0 || x==1.0) return 1.0;
        if (x == 0) {
            return 0;
        }
        if(n<0) return 1/myPow(x, Math.abs(n));
        if(n%2 == 0) 
            return myPow(x*x, n/2);
        else
            return x * myPow(x, n-1);
    }
}
